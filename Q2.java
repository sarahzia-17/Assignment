class SimpleSelectionSort {
    public static void main(String[] args) {
        String[] names = {"Ali", "Zara", "Omar", "Bilal", "Hina"};

        for (int i = 0; i < names.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < names.length; j++) {
                if (names[j].compareTo(names[min]) < 0) {
                    min = j;
                }
            }
            String temp = names[i];
            names[i] = names[min];
            names[min] = temp;
        }

        System.out.println("Sorted names:");
        for (int i = 0; i < names.length; i++) {
            System.out.println(names[i]);
        }
    }
}
