package com.luke.util;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;

public class CommentsThread implements   Callable<List>{
	
	
	List<Map<String, Object>> pLlist ;
	List<Map<String, Object>> hFlist ;
	List<Map<String, Object>> resList = new LinkedList<Map<String, Object>>();
	String name;
	public CommentsThread(List<Map<String, Object>> pLlist,List<Map<String, Object>> hFlist,String name){
		this.pLlist = pLlist;
		this.hFlist = hFlist;
		this.name = name;
	}

	@Override
	public List call() throws Exception {
		synchronized ( resList) {
			for(int pl =0 ; pl<pLlist.size();pl++){
				Map map = new Hashtable();
				Integer pLId =(Integer) pLlist.get(pl).get("id");
				List <String> namelist = new  LinkedList<String>();
				for(int hf = 0; hf <hFlist.size();hf++){
					if((Integer) hFlist.get(hf).get("pid") == pLId){
						namelist.add(hFlist.get(hf).get(name).toString());
					}
				}
				map.put(name, namelist);
				resList.add(map);
			}
		}    
		return resList;
	}

	
	
	
}
