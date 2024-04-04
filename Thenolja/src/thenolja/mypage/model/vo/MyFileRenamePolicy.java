package thenolja.mypage.model.vo;

import java.io.File;

import com.oreilly.servlet.multipart.FileRenamePolicy;

public class MyFileRenamePolicy implements FileRenamePolicy{
   
   
   @Override
   public File rename(File originFile) {
      
      // 원본 파일명!!
      
      // String currentTime = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
      
      // int randomNo = (int)(Math.random() * 90000) + 10000;
      
      // String ext = originName.substring(originName.lastIndexOf("."));
      int sum = 0;
      for(int i = 0; i < 10000; i++ ) {
    	  sum += i;
      }
         
      String originName = originFile.getName();
      String changeName = "profile" + sum;
      
      return new File(originFile.getParent(), changeName);
   }
   
      
   
}
