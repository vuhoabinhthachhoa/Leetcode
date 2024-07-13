class Solution {
   public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        int[][] robots = new int[positions.length][3];
        for (int i = 0; i < positions.length; i++) {
            robots[i][0] = positions[i];
            robots[i][1] = healths[i];
            robots[i][2] = directions.charAt(i) == 'L' ? -1 : 1;
        }
        // sort by position in ascending order
        Arrays.sort(robots, Comparator.comparingInt(a -> a[0]));
        Stack<int[]> st = new Stack<>();
        // robot = [position, health, direction]
        int[] rightRobot = new int[3];
        int i = 0;
        while(i < robots.length) {
            rightRobot[0] = robots[i][0];
            rightRobot[1] = robots[i][1];
            rightRobot[2] = robots[i][2];
            // if no collision
            if(st.empty() || st.peek()[2] != 1 || rightRobot[2] != -1) {
                st.push(new int[]{rightRobot[0], rightRobot[1], rightRobot[2]});
            }
            // if collision
            else {
                // loop while there is a collision between left and right robot
                while(true){
                    int[] leftRobot = st.pop();
                    if(leftRobot[1] > rightRobot[1]) {
                        // if left robot has more health, right robot is destroyed
                        // then set the rightRobot as a next robot
                        st.push(new int[]{leftRobot[0], leftRobot[1] - 1, leftRobot[2]});
                        break;
                    }
                    else if(leftRobot[1] < rightRobot[1]) {
                        // if right robot has more health, left robot is destroyed
                        // set leftRobot as a next element in the stack and check again
                        rightRobot[1] = rightRobot[1] - 1;
                        // if stack is empty or the left robot does not move to the right,
                        // there is no collision anymore, then push the right robot to the stack and move to the next robot
                        if(st.empty() || st.peek()[2] != 1){
                            st.push(new int[]{rightRobot[0], rightRobot[1], rightRobot[2]});
                            break;
                        }
                    }
                    else {
                        break;
                    }
                }
            }
            i++;
        }

        // we have to use a map to store the corresponding health of the robot at the position
        Map<Integer, Integer> map = new HashMap<>();
        while(!st.empty()) {
            map.put(st.peek()[0], st.peek()[1]);
            st.pop();
        }
        List<Integer> res = new ArrayList<>();
        for(int j = 0; j < positions.length; j++) {
            int health = (map.getOrDefault(positions[j], -1));
            if(health != -1) {
                res.add(health);
            }
        }
        return res;
    }
}