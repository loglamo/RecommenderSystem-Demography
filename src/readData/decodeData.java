/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package readData;
import static java.lang.Integer.parseInt;
import static java.lang.Math.pow;
import static java.lang.Math.sqrt;
import java.lang.reflect.Array;
import java.util.ArrayList;
//lớp này để phân tích dữ liệu đã đọc được
//lưu các thông tin idUser,idFilm,đánh giá,time vào ArrayList
//mỗi thành phần ArrayList lại là 1 ArrayList các số id lưu trữ thông tin.
public class decodeData{
    public static ArrayList DecodeData(){
    ArrayList data = readData.readData();
    ArrayList afterData = new ArrayList();
    /*for(int i = 0;i < data.size();i++){*/
    //String line = (String) data.get(10);
    for(int i=0;i < data.size();i++){
    ArrayList newLine = new ArrayList();
    String line = (String) data.get(i);
    String[] item = line.split("\\s");
    for(String W:item){
        int a =parseInt(W);
        newLine.add(a);
    }
    afterData.add(newLine);
          }
    return afterData;
    }
    //tao matrix rate(ma trận đánh giá của người sử dụng đối vs các bộ phim;
    public static ArrayList MakeRatedMatrix(){
        ArrayList data = DecodeData();
        ArrayList ratedMatrix = new ArrayList();
        for(int e = 1;e < 943;e++){
            ArrayList user = new ArrayList();
            for(Object x:data){
                ArrayList y = (ArrayList) x;
                int item = (int) y.get(0);
                if(item == e ){
                    ArrayList rate = new ArrayList();
                    int IdFilm = (int) y.get(1);
                    rate.add(IdFilm);
                    int point = (int) y.get(2);
                    rate.add(point);
                    user.add(rate);
                }else continue;
                }
            ratedMatrix.add(user);
            }
        return ratedMatrix;
    }
    //hiển thị danh sách đánh giá của 943 người dùng với từng bộ film;
   public static void PrintMatrix(){
       ArrayList RatedMatrix = MakeRatedMatrix();
       for(int i = 0;i < RatedMatrix.size();i++){
           System.out.println("User" + i + RatedMatrix.get(i));
       }
   } 
   /*public static void main(String[] args){
       PrintMatrix();
       
       
   }*/

   
   //phương thức tính giá trị TB đánh giá đối với film i
   /*public static float CalAverageRate(int i){
       ArrayList ratedMatrix = MakeRatedMatrix();
       int total = 0;
       int count = 0;
       for(Object x:ratedMatrix){
           ArrayList y = (ArrayList) x;
           for (Object y1 : y) {
               ArrayList rate = (ArrayList) y1;
               int idFilm = (int) rate.get(0);
               int point = (int) rate.get(1);
               if(idFilm == i){
                   total += point;
                   count++;
                   break;
               }else continue;
           }
       }
       float AverageRate = (float)(total/count);
       return AverageRate;
   }*/
   //phương thức lưu trữ tập các đánh giá đối vs film i
   public static ArrayList RateArray(int k){
       ArrayList ratearray = new ArrayList();
       ArrayList ratedMatrix = MakeRatedMatrix();
       for(Object x:ratedMatrix){
           ArrayList y = (ArrayList) x;
           for(Object y1:y){
               ArrayList rate = (ArrayList) y1;
               int idFilm = (int) rate.get(0);
               int point = (int) rate.get(1);
               if(idFilm == k){
                   ratearray.add(point);
                   break;
               }else continue;
           }
       }
       return ratearray;
   }
   //phuong thuc tinh danh gia rung binh doi voi phim i
   public static float CalAverageRate(int i){
       ArrayList ratearray = RateArray(i);      
       float total = 0;
       for(int e=0;e < ratearray.size();e++){
           float rate = (float) ratearray.get(e);
           total += rate;
           
       }
       float average = (float) total/ratearray.size();
       return average;
   }

   
   //phương thức xác định đánh giá của nhg người cùng đánh giá film i, j
   public static ArrayList BothRate(int i,int j){
       ArrayList ratedMatrix = MakeRatedMatrix();
       ArrayList bothRateMatrix = new ArrayList();//arraylist lưu trữ những người sử dụng cùng đánh giá i và j, lưu trữ tất cả nhg film người đó đã đánh giá bao gồm cả i, j
       for(Object x:ratedMatrix){
           int count = 0;
           ArrayList y = (ArrayList) x;
           for(Object y1:y){
               ArrayList rate = (ArrayList) y1;
               int idFilm = (int) rate.get(0);
               if((idFilm == i)||(idFilm == j)){
                   count++;
               }else continue;
           }
           if(count == 2){
               bothRateMatrix.add(x);
           }else continue;
       }
       ArrayList rateI = new ArrayList();
       ArrayList rateJ = new ArrayList();
       for(Object a:bothRateMatrix){
           ArrayList a1 = (ArrayList) a;
           for(Object b:a1){
               ArrayList b1 = (ArrayList) b;
               int id =(int) b1.get(0);
               int pointrate = (int) b1.get(1);
               if(id == i){
                   rateI.add(pointrate);
               }else if(id == j){
                   rateJ.add(pointrate);
               }else continue;
           }
       }
       ArrayList rateij = new ArrayList();
       rateij.add(rateI);
       rateij.add(rateJ);
       return rateij;
     
}

   /*public static void main(String[] args){
       ArrayList a = BothRate(1,2);
      
           System.out.println(a.get(0));
           System.out.println(a.get(1));
       }
}*/
   //phương thức tính tử số của biếu thức pearson
   public static float CalFirst(int m,int n){
       float averageOfI = CalAverageRate(m);
       float averageOfJ = CalAverageRate(n);
       ArrayList bothrate = BothRate(m,n);
       ArrayList rateI = (ArrayList) bothrate.get(0);
       ArrayList rateJ = (ArrayList) bothrate.get(1);
       float total = 0;
       int lengthij = rateI.size();
       for(int k=0;k < lengthij;k++){
           int rateIK = (int) rateI.get(k);
           int rateJK = (int) rateJ.get(k);
           float feature = (float) ((rateIK - averageOfI)*(rateJK - averageOfJ));
           total += feature;
            
        }
       return total;
 }
   //phương thức tính mẫu số của biểu thức Pearson
   public static float CalSecond(int m,int n){
       float averageOfI = CalAverageRate(m);
       float averageOfJ = CalAverageRate(n);
       ArrayList bothrate = BothRate(m,n);
       ArrayList rateI = (ArrayList) bothrate.get(0);
       ArrayList rateJ = (ArrayList) bothrate.get(1); 
       float totali = 0;
       float totalj = 0;
       float total;
       int lengthij = rateI.size();
       for(int k=0;k < lengthij;k++){
           int rateIK = (int) rateI.get(k);
           int rateJK = (int) rateJ.get(k);
           double a = (double) (rateIK - averageOfI);
           double a2 = pow(a,2);
           double b = (double) (rateJK - averageOfJ);
           double b2 = pow(b,2);
           totali += a2;
           totalj += b2;
       }
       float second = (float) ((sqrt(totali))*(sqrt(totalj)));
       return second;
   }
   //phương thức tính độ tương đồng giữa 2 film
   public static float CalDis(int m,int n){
       float first = CalFirst(m,n);
       float second = CalSecond(m,n);
       float total = (float) (first/second);
       return total;
   }
}
   //ma trận tương đồng giữa các bộ film
  /* public static ArrayList DissMatrix(){
       ArrayList dissmatrix = new ArrayList();
       for(int i=1;i < 1682;i++){
           ArrayList feature = new ArrayList();
           for(int k=1;k < 1682;k++){
               float diss = CalDis(i,k);
               feature.add(diss);
           }
           dissmatrix.add(feature);
           
       }
       return dissmatrix;
   }

   public static void main(String[] args){
       ArrayList y = DissMatrix();
       System.out.println(y.get(0));
       //for(int e = 0;e < y.size();e++){
       //    System.out.println(y.get(e));
       }
}


   //phương thức tính độ tương đồng của 2 bộ film;
   /*public static float calDis()
    public static void main(String[] args){
             ArrayList test = MakeRatedMatrix();
             PrintMatrix();
    }
    
    
    
    
    
    }
            
    /*public static void main(String[] args){
        ArrayList NewData = DecodeData();
        for(int k=0;k < NewData.size();k++){
            System.out.println(NewData.get(k));
        }*/

        /*String item2 = line.substring(4,8);
        String item3 = line.substring(8,9);
        String item4 = line.substring(9,18);
        newLine.add(item1);
        newLine.add(item2);
        newLine.add(item3);
        newLine.add(item4);
        item.add(newLine);
        System.out.println(item);
    }*/


