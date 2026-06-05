//This is an UnNamed Class

static void duplicateValueLastIndex(int[] k) {
    HashSet<Integer> set = new HashSet<>();
    IntStream.range(0, k.length).filter(i -> !set.add(k[i]))
            .forEach(f -> System.out.println("Index : Value = " + f + " : " + k[f]));

}

static void duplicateValueAllIndexesMap(int[] k) {
    Map<Integer, List<Integer>> map = IntStream.range(0, k.length).boxed()
            .collect(Collectors.groupingBy(i -> k[i]));
    map.entrySet().stream().filter(e -> e.getValue().size() > 1)
            .forEach(e -> System.out.println("Value : Indices = " + e.getKey() + " : " + e.getValue()));
}

static int[] mergeSortedArraysInOrder(int[] a, int[] b) {
    int[] c = new int[a.length + b.length];

    int i = 0, j = 0, k = 0;
    while (i < a.length && j < b.length) {
        if (a[i] <= b[j]) {
            c[k++] = a[i++];
        } else {
            c[k++] = b[j++];
        }
    }
    while (i < a.length)
        c[k++] = a[i++];
    while (j < b.length)
        c[k++] = b[j++];

    return c;
}

static int[] mergeSortedArraysUsingStreamAPI(int[] a, int[] b) {
    return IntStream.concat(Arrays.stream(a), Arrays.stream(b)).sorted().toArray();
}

void main() {
    int[] a = { 1, 2, 3, 4, 5 };
    int[] b = { 6, 7, 8, 9, 10 };

    System.out.println(Arrays.toString(mergeSortedArraysInOrder(a, b)));
    System.out.println(Arrays.toString(mergeSortedArraysUsingStreamAPI(a, b)));

    int[] d = { 1, 2, 3, 3, 1 };
    duplicateValueLastIndex(d);
    duplicateValueAllIndexesMap(d);
}
