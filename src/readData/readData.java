/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 *
*/
package readData;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
public class readData{
    //đọc dữ liệu từ file, lưu trong ArrayList
    //đọc dữ liệu sử dụng bufferedreader
    public static ArrayList readData(){
        BufferedReader br = null;
        ArrayList data= new ArrayList();
        try{
            String sCurrentLine;
            br = new BufferedReader(new FileReader("test/u1.base"));
            while((sCurrentLine = br.readLine()) != null){
                data.add(sCurrentLine);
            }
    }catch(IOException e){
        e.printStackTrace();
    }
        return data;
    }
    /*public static void main(String[] args){
        ArrayList data = readData();
        for(int i=0;i < data.size();i++){
            System.out.println(data.get(i));
        }
    }*/
}
