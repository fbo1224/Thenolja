package thenolja.tb_review.model.vo;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.oreilly.servlet.multipart.FileRenamePolicy;

// FileRenamePolicy를 구현해서 이름 바꾸기 정책을 사용할 예정
public class MyFileRenamePolicy implements FileRenamePolicy{
   
   
   @Override
   public File rename(File originFile) {
      
      // 원본 파일명!!
      String originName = originFile.getName();
      
      String currentTime = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
      
      int randomNo = (int)(Math.random() * 90000) + 10000;
      
      String ext = originName.substring(originName.lastIndexOf("."));
         
      String changeName = "review" + currentTime + "_" + randomNo + ext;
      
      return new File(originFile.getParent(), changeName);
      
      
      
      
   }
   
      
   
}
