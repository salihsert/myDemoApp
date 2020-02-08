package com.mycompany.app;
import java.util.Arrays;


public class App{
	
	// ikinci dizinin belirtilen index aralığını ilk dizinin belirtilen index aralığıyla değiştirir
	public static int[] replace(int ar1[], int ar2[], int index1, int index2){
		if(index1<0 || index2<0){
			System.out.println("Belirtilen index bulunamadı");
			return null;
		}
		int l1=ar1.length;
		int l2=ar2.length;
		if(index1>=l1 || index1>=l2 || index2>=l1 || index2>=l2){
			System.out.println("Belirtilen index bulunamadı");
			return null;
		}
		System.out.println(Arrays.toString(ar1));
		System.out.println(Arrays.toString(ar2));
		for(int i=index1;i<=index2;i++){
			int a=ar1[i];
			ar2[i]=a;
		}
		System.out.println("---------------After process----------");
		System.out.println(Arrays.toString(ar2));
		return ar2;
	}
}

