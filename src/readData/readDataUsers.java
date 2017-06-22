/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package readData;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.io.File;
import java.io.FileReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
/**
 *
 * @author lahu
 */
public class readDataUsers{
    public static ArrayList ReadDataUser(){
        BufferedReader br = null;
        ArrayList data = new ArrayList();
        try{
            String Line;
            br = new BufferedReader(new FileReader("test/u.user"));
            while((Line = br.readLine())!= null){
                data.add(Line);
            }
        }catch(IOException e){
            e.printStackTrace();
        }
        return data;
        
    }
    public static ArrayList DecodeDataUser(){
        ArrayList Data = ReadDataUser();
        ArrayList AfterData = new ArrayList();
        for(int i=0;i < Data.size();i++){
            ArrayList NewLine = new ArrayList();
            String Line = (String) Data.get(i);
            String[] Item = Line.split("\\W");
            for(Object W:Item){
                NewLine.add(W);
            }
            AfterData.add(NewLine);
        }
        return AfterData;
    }
    
    
    /*public static void main(String[] args){
        ArrayList a = new ArrayList();
        a = DecodeDataUser();
        for(int i=0;i < a.size();i++){
            System.out.println(a.get(i));
        }
    }*/
}
