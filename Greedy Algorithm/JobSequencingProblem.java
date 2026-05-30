// File: JobSequencingProblem.java

import java.util.*;

class Job {
    int id, deadline, profit;

    Job(int id, int deadline, int profit) {
        this.id = id;
        this.deadline = deadline;
        this.profit = profit;
    }
}

public class JobSequencingProblem {

    public static int[] jobScheduling(int[][] jobsArr) {

        int n = jobsArr.length;
        Job[] jobs = new Job[n];

        for (int i = 0; i < n; i++) {
            jobs[i] = new Job(jobsArr[i][0], jobsArr[i][1], jobsArr[i][2]);
        }

        Arrays.sort(jobs, (a, b) -> b.profit - a.profit);

        int maxDeadline = 0;
        for (Job job : jobs) {
            maxDeadline = Math.max(maxDeadline, job.deadline);
        }

        int[] slot = new int[maxDeadline + 1];
        Arrays.fill(slot, -1);

        int count = 0, totalProfit = 0;

        for (Job job : jobs) {

            for (int j = job.deadline; j > 0; j--) {

                if (slot[j] == -1) {
                    slot[j] = job.id;
                    count++;
                    totalProfit += job.profit;
                    break;
                }
            }
        }

        return new int[]{count, totalProfit};
    }

    public static void main(String[] args) {

        int[][] jobs1 = {
            {1, 4, 20},
            {2, 1, 10},
            {3, 1, 40},
            {4, 1, 30}
        };

        int[] res1 = jobScheduling(jobs1);
        System.out.println(res1[0] + " " + res1[1]); // 2 60

        int[][] jobs2 = {
            {1, 2, 100},
            {2, 1, 19},
            {3, 2, 27},
            {4, 1, 25},
            {5, 1, 15}
        };

        int[] res2 = jobScheduling(jobs2);
        System.out.println(res2[0] + " " + res2[1]); // 2 127
    }
}