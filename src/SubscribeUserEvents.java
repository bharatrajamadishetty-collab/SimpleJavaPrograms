
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

enum EventType {
    MESSAGE,
    CALENDAR_INVITE,
    NOTIFICATION
}

record Event(EventType eventType, String content) {
}

interface Subscriber {
    void update(Event event);

    String getName();
}

// Subscriber
class User implements Subscriber {
    private final String name;

    public User(String name) {
        this.name = name;
    }

    @Override
    public void update(Event event) {
        System.out.println(name + " received [" + event.eventType() + "]: " + event.content());
    }

    @Override
    public String getName() {
        return name;
    }
}

// Publisher
class EventManager {
    private final Map<EventType, List<Subscriber>> subscribers = new HashMap<>();

    public EventManager() {
        for (EventType type : EventType.values()) {
            subscribers.put(type, new ArrayList<>());
        }
    }

    public void subscribe(EventType type, Subscriber user) {
        subscribers.get(type).add(user);
        System.out.println(user.getName() + " subscribed to " + type);
    }

    public void unsubscribe(EventType type, Subscriber user) {
        subscribers.get(type).remove(user);
        System.out.println(user.getName() + " unsubscribed from " + type);
    }

    public void notifySubscribers(Event event) {
        List<Subscriber> users = subscribers.get(event.eventType());
        for (Subscriber user : users) {
            user.update(event);
        }
    }
}

public class SubscribeUserEvents {
    public static void main(String[] args) {

        EventManager manager = new EventManager();

        User laura = new User("Laura");
        User bharat = new User("Bharat");

        // Subscriptions
        manager.subscribe(EventType.MESSAGE, laura);
        manager.subscribe(EventType.NOTIFICATION, laura);

        manager.subscribe(EventType.MESSAGE, bharat);
        manager.subscribe(EventType.CALENDAR_INVITE, bharat);

        // Send events
        manager.notifySubscribers(new Event(EventType.MESSAGE, "New message received!"));
        manager.notifySubscribers(new Event(EventType.CALENDAR_INVITE, "Meeting at 3 PM"));
        manager.notifySubscribers(new Event(EventType.NOTIFICATION, "Someone liked your post!"));

        manager.unsubscribe(EventType.MESSAGE, bharat);

        System.out.println("\nAfter bharat unsubscribes:\n");

        // Send again
        manager.notifySubscribers(new Event(EventType.MESSAGE, "Another message!"));
        manager.notifySubscribers(new Event(EventType.NOTIFICATION, "10 comments your post!"));
        manager.notifySubscribers(new Event(EventType.CALENDAR_INVITE, "Project discussion at 5 PM"));
    }

}
