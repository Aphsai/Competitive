/**
 * Created by Saksham on 2016-03-06.
 */
import java.util.*;
public class ThirtyNinth {
    public static int min(int[] blood, int[] patients, int x, int y) {
        int w = Math.min(blood[x], patients[y]);
        blood[x] -=w;
        patients[y] -=w;
        return w;
    }
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
       int[] blood = new int[8];
        int[] patients = new int[8];
        int total = 0;
        for (int x =0;x < 8; x++) {
            blood[x] = s.nextInt();
        }
        int tot = 0;
        for (int x =0 ; x < 8; x++) {
            patients[x] = s.nextInt();
            tot+= patients[x];
        }
        total += min(blood,patients, 0,0);
        total += min(blood,patients, 1,1);
        total+= min(blood,patients, 0,1);
        total += min(blood, patients,2,2);
        total += min(blood,patients, 0,2);
        total += min(blood,patients, 3,3);
        total += min(blood,patients, 2,3);
        total += min(blood,patients, 4,4);
        total += min(blood,patients, 0,4);
        total += min(blood,patients, 6,6) + min(blood,patients, 0,6);
        total += min(blood,patients, 0,3);
        total += min(blood,patients, 1,3);
        total += min(blood, patients, 5,5);
        total += min(blood,patients, 4,5);
        total += min(blood,patients, 0, 5);
        total += min(blood,patients, 1,5);
        total += min(blood,patients, 4,6) + min(blood,patients,2,6);
        total += min(blood,patients, 6,7) + min(blood,patients, 4,7) + min(blood,patients,2,7) + min(blood,patients, 0,7) + min(blood,patients, 1,7) + min(blood,patients, 3,7) + min(blood,patients, 5,7) + min(blood,patients,7,7);
        int left = 0;
        for (int x =0; x < 8; x++){
            left += patients[x];
        }

        System.out.println(tot - left);
//        for (int x = 0; x < 8; x++) {
//            blood[x] -= patients[x];
//        }
//        while (blood[2] > 0 && blood[3] < 0) {
//            blood[2]--;
//            blood[3]++;
//        }
//        while(blood[4] > 0 && blood[5] < 0) {
//            blood[4]--;
//            blood[5]++;
//        }
//        while (blood[0] > 0) {
//            if (blood[2] < 0) {
//                blood[2]++;
//                blood[0]--;
//                continue;
//            }
//            else if (blood[4] < 0) {
//                blood[4]++;
//                blood[0]--;
//                continue;
//            }
//            else if (blood[3] < 0) {
//                blood[3]++;
//                blood[0]--;
//                continue;
//            }
//            else if (blood[5] <0) {
//                blood[5]++;
//                blood[0]--;
//                continue;
//            }
//            else
//                break;
//        }
//        while (blood[0] > 0 && blood[1] < 0) {
//            blood[0]--;
//            blood[1]++;
//        }
//        while (blood[1] > 0 && blood[3] < 0) {
//            blood[1]--;
//            blood[3]++;
//        }
//        while (blood[1] > 0 && blood[5] < 0) {
//            blood[1]--;
//            blood[5]++;
//        }
//        while((blood[0] > 0 || blood[2] > 0 || blood[4] > 0) && blood[6] < 0) {
//            if (blood[0] > 0) {
//                blood[0]--;
//                blood[6]++;
//                continue;
//            }
//            else if (blood[2]>0) {
//                blood[2]--;
//                blood[6]++;
//                continue;
//            }
//            else if (blood[4]> 0) {
//                blood[4]--;
//                blood[6]++;
//                continue;
//            }
//            else break;
//        }
//        while((blood[0] > 0 || blood[1] > 0 ||  blood[2] > 0 || blood[4] > 0|| blood[3] > 0 || blood[5] < 0 || blood[6] < 0) && blood[7] < 0) {
//            if (blood[0] > 0 && blood[7] < 0) {
//                blood[0]--;
//                blood[7]++;
//            }
//            if (blood[1] > 0 && blood[7] < 0) {
//                blood[1]--;
//                blood[7]++;
//            }
//            if (blood[2]>0 && blood[7] < 0) {
//                blood[2]--;
//                blood[7]++;
//            }
//            if (blood[6] > 0 && blood[7] < 0) {
//                blood[6]--;
//                blood[7]++;
//            }
//            if (blood[4]> 0 && blood[7] < 0) {
//                blood[4]--;
//                blood[7]++;
//            }
//            if (blood[1] > 0 && blood[7] < 0) {
//                blood[1]--;
//                blood[7]++;
//            }
//            if (blood[3]>0 && blood[7] < 0) {
//                blood[3]--;
//                blood[7]++;
//            }
//            if (blood[5]> 0 && blood[7] < 0) {
//                blood[5]--;
//                blood[7]++;
//            }
//        }
//        int saved = 0;
//        for (int x =0 ; x < 8; x++) {
//            if (blood[x] < 0) {
//                saved += blood[x];
//            }
//        }
//        System.out.println(total + saved);
    }
}
