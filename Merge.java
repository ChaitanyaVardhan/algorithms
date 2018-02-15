public class Merge {
    public static void merge(Comparable[] a, Comparable[] aux, int lo, int mid, int hi) {
	for ( i = lo; i < hi; i++) { aux[i] = a[i]; }
	for ( i = lo, j = mid + 1; i <= mid; i++) {
	    if (i > mid) { a[i] = aux[j++]; }
	    if (j > hi) { a[i] = aux[i]; }
	    if (aux[i] <= aux[j]) { a[i] = aux[i]; }
	    if (aux[i] > aux[j]) { a[i] = aux[j++];}
	}
    }

    public static void sort(Comparable[] a, Comparable[] aux, int lo, int hi) {
	int mid = lo + (hi - lo)/2;
	sort(a, aux, lo, mid);
	sort(a, aux, mid + 1, hi);
	merge(a, aux, lo, mid, hi);
    }

    public static void sort(Comparable[] a) {
	aux = new Comparable[a.length - 1];
	sort(a, aux, 0, a.length - 1);
    }
}
