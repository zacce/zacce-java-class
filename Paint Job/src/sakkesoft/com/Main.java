package sakkesoft.com;

public class Main {

    public static void main(String[] args) {
        System.out.println(getBucketCount(12,10,3,-2));
    }
    public static int getBucketCount(double width,double height,double areaPerBucket,double extraBuckets){
        if ((width<0)||(height<0)||(areaPerBucket<0)||(extraBuckets<0)){
            return -1;
        }else{
            System.out.println("Kukkuu");
            return 1;
        }
    }

}
