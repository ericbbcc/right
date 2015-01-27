package com.teamdev.jxbrowser.chromium.demo;


import java.util.List;

import com.teamdev.jxbrowser.chromium.dom.DOMDocument;
import com.teamdev.jxbrowser.chromium.dom.DOMElement;
import com.teamdev.jxbrowser.chromium.dom.DOMNode;
import com.teamdev.jxbrowser.chromium.events.FinishLoadingEvent;
import com.teamdev.jxbrowser.chromium.events.LoadAdapter;

public class PageLoadListener extends LoadAdapter{
	 @Override
     public void onFinishLoadingFrame(FinishLoadingEvent event){

		 if (event.isMainFrame()) {
             DOMDocument document = event.getBrowser().getDocument();
             DOMNode content = document.getElementById("v6_pl_content_homefeed");
             List<DOMNode> usercards = content.querySelectorAll("div[pagenum] a[usercard]");
             for(DOMNode u : usercards){
            	 DOMElement eu = (DOMElement)u;
            	 processEachNode(eu);
             }
         }
     }
	 
	 private void processEachNode(DOMElement n){
		 DOMElement detailInfo = (DOMElement)n.getParent().getParent();
		 detailInfo.getInnerHTML();
		 DOMElement c = (DOMElement)detailInfo.querySelector("div[node-type=feed_list_content]");
		 System.out.print("UserName: " + n.getInnerHTML().trim());
		 System.out.print("\t\t\t");
		 if(c != null)
			 System.out.println("Content: " + c.getInnerHTML().trim());
	 }
}
