package exercise;

class SafetyList {
    // BEGIN
    private int[] nums = new int[0];
    private int length = 0;

    public synchronized void add(int number) {
        int[] array = new int[length + 1];
        array[length] = number;
        nums = array;
        length++;
    }

    public int get(int index) {
        return nums[index];
    }

    public int getSize() {
        return this.length;
    }
    // END
}
