/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recommenderSystem;
import java.util.ArrayList;
import readData.readDataUsers;
import java.io.*;
import static java.lang.Integer.parseInt;

/**
 *
 * @author ADMIN
 */
public class demography {
    // tim nhg users tuong dong
    //public static ArrayList TakeSimUsers(ArrayList user){
     public static void main(String args[]){ 
        //int age = (Integer) user.get(0);//OK
        //String sex = (String) user.get(1);//OK
        ArrayList user = new ArrayList();
        user.add(25);
        user.add("M");
        int age = (Integer) user.get(0);
        String sex = (String) user.get(1);
        int id;
        if(age <= 9)id = 0;
        else if((age <=19)&&(age >= 10))id = 1;
        else if((age <= 45)&&(age >=20))id = 2;
        else if((age <= 60)&&(age >= 46))id =3;
        else id = 4;
        //System.out.println(id);
        ArrayList simusers = new ArrayList();
        ArrayList DataUser = readDataUsers.DecodeDataUser();
        //for(int i=0;i < DataUser.size();i++){
            ArrayList useri = (ArrayList) DataUser.get(0);
            String agei = (String) useri.get(1);
            int ageii = parseInt(agei);//tuoi
            String sexi = (String) useri.get(2);//gioi tinh
            int ed;
            if(ageii <= 9)ed =0;
            else if((ageii <= 19)&&(ageii >= 10))ed =1;
            else if((ageii <= 45)&&(ageii >= 20))ed = 2;
            else if((ageii <= 60)&&(ageii >= 46))ed =3;
            else ed = 4;
            //String a = "lananh";
            String idUser = (String) useri.get(0);
            
            if((sexi == sex)&&(ed == id)){//sai chỗ so sánh này?????
                //String idUser = (String) useri.get(0);
                //simusers.add(idUser);
                System.out.println(sex);
            }else
        
        System.out.println(idUser);
            //else continue;
        
        //return simusers;
      //System.out.println(id);
    }
}

    
    /*public static void main(String args[]){
        ArrayList a = new ArrayList();
        a.add(24);
        a.add("lananh");
        ArrayList sim= (ArrayList) TakeSimUsers(a);
        for(int k=0;k < sim.size();k++){
            System.out.println(sim.get(k));
        }
    }
}*/

        /*Strring age = (String) user.get(0);
        int agen = parseInt(age);
        int id = 0;
        if(agen <= 9)id=0;
        if((agen <= 19)&&(agen >=10))id = 1;
        if((agen <= 45)&&(agen >= 20))id = 2;
        if((agen <= 60)&&(agen >= 46))id = 3;
        if (agen > 60)id =4;
        String sex = (String) user.get(1);
        ArrayList DataUser = readDataUsers.DecodeDataUser();
        ArrayList SimUser = new ArrayList();
        for(int i=0; i < DataUser.size();i++){
            ArrayList userI = (ArrayList) DataUser.get(i);
            String idUser = (String) userI.get(0);
            String ageI = (String) userI.get(1);
            int ageIn = parseInt(ageI);
            int ed = 0;
            if(ageIn <= 9)ed = 0;
            if((ageIn <= 19)&&(ageIn >= 10))ed = 1;
            if((ageIn <= 45)&&(ageIn >= 20))ed = 2;
            if((ageIn <= 60)&&(ageIn >= 46))ed = 3;
            if(ageIn > 60)ed = 4;
            String sexI = (String) userI.get(2);
            if((sex == sexI)&&(id == ed)){
                SimUser.add(idUser);
        }
        }
        return SimUser;
            }*/
    /*public static void main(String[] args){
        ArrayList user = new ArrayList();
        user.add("9");
        user.add("F");
        ArrayList a = TakeSimUsers(user);
        for(int i = 0; i < a.size();i++){
            System.out.println(a.get(i));
        }
    }*/
    

