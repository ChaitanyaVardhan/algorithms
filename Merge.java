public class Merge {
    public static void merge(Comparable[] a, Comparable[] aux, int lo, int mid, int hi) {
	for ( int k = lo; k < hi; k++) 
	    aux[k] = a[k];

	int i = lo, j = mid + 1;
	for ( int k = lo; k <= hi; k++) {
	    if (i > mid)                     a[k] = aux[j++];
	    else if (j > hi)                 a[k] = aux[i++];
	    else if (less(aux[i],aux[j]))    a[k] = aux[i++];
	    else                             a[k] = aux[j++];
	}
    }

    public static void sort(Comparable[] a, Comparable[] aux, int lo, int hi) {
	if (hi<=lo) return;
	int mid = lo + (hi - lo)/2;
	sort(a, aux, lo, mid);
	sort(a, aux, mid + 1, hi);
	merge(a, aux, lo, mid, hi);
    }

    public static void sort(Comparable[] a) {
	Comparable[] aux = new Comparable[a.length];
	sort(a, aux, 0, a.length - 1);
    }

    private static boolean less(Comparable a, Comparable b) {
	if (a.compareTo(b) < 0) return true;
	else return false;
    }

    private static void show(Comparable[] a) {
	for (int i = 0; i < a.length; i++) 
	    StdOut.println();
    }

    public static void main(String[] args) {
	String[] a = StdIn.readAllStrings();
	Merge.sort(a);
	show(a);
	StdOut.println();
    }

}
