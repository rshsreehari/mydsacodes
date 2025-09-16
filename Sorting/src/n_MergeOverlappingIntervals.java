import java.util.Arrays;

public class n_MergeOverlappingIntervals {
    /*
    given an array of multiple intervals. check the overlapping intervals and merge them.
    Later give a result which give non overlapping merged intervals

    idea is to check if they lie in other pair interval or not.
    this is done by checking in any one of below 2 ways:

    Take Max of 2 intervals start values and check if they lie in other interval or not
    Take Min of 2 intervals end values and check if they lie in other interval or not

    eff solution:
    Sort all intervals with Inc order of start time

     */
    public static void main(String[] args) {
        Interval arr[] = {new Interval(5, 10), new Interval(3, 15), new Interval(18, 30),
                new Interval(2, 7)};

        int n = arr.length;

        mergeIntervals(arr, n);
    }

    static void mergeIntervals(Interval arr[], int n) {
        Arrays.sort(arr);

        int res = 0;

        for (int i = 1; i < n; i++) {
            if (arr[res].e >= arr[i].s) {
                arr[res].e = Math.max(arr[res].e, arr[i].e);
                arr[res].s = Math.min(arr[res].s, arr[i].s);
            } else {
                res++;
                arr[res] = arr[i];
            }
        }

        for (int i = 0; i <= res; i++)
            System.out.print("[" + arr[i].s + ", " + arr[i].e + "] ");


    }
}

class Interval implements Comparable<Interval>
{
    int s, e;

    Interval(int s, int e)
    {
        this.s = s;
        this.e = e;
    }

    public int compareTo(Interval a)
    { return this.s - a.s; }
};