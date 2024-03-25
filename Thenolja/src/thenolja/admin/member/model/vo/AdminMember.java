package thenolja.admin.member.model.vo;

import java.sql.Date;

public class AdminMember {
   
   private int memNo;
   private String memId;
   private String memPwd;
   private String nickName;
   private String bornDate;
   private String email;
   private String deleteYn;
   private String joinDate;
   private String memName;
   private String memPhone;
   private String memStatus;
   private String gradeName;
   private int paymentPrice;


   public int getPaymentPrice() {
      return paymentPrice;
   }

   public void setPaymentPrice(int paymentPrice) {
      this.paymentPrice = paymentPrice;
   }

   public String getMemName() {
      return memName;
   }

   public void setMemName(String memName) {
      this.memName = memName;
   }

   public String getMemPhone() {
      return memPhone;
   }

   public void setMemPhone(String memPhone) {
      this.memPhone = memPhone;
   }

   public String getMemStatus() {
      return memStatus;
   }

   public void setMemStatus(String memStatus) {
      this.memStatus = memStatus;
   }

   public String getGradeName() {
      return gradeName;
   }

   public void setGradeName(String gradeName) {
      this.gradeName = gradeName;
   }

   public AdminMember() {
      super();
   }

   public AdminMember(int memNo, String memId, String memPwd, String nickName, String bornDate, String email,
         String deleteYn, String joinDate) {
      super();
      this.memNo = memNo;
      this.memId = memId;
      this.memPwd = memPwd;
      this.nickName = nickName;
      this.bornDate = bornDate;
      this.email = email;
      this.deleteYn = deleteYn;
      this.joinDate = joinDate;
   }

   public int getMemNo() {
      return memNo;
   }

   public void setMemNo(int memNo) {
      this.memNo = memNo;
   }

   public String getMemId() {
      return memId;
   }

   public void setMemId(String memId) {
      this.memId = memId;
   }

   public String getMemPwd() {
      return memPwd;
   }

   public void setMemPwd(String memPwd) {
      this.memPwd = memPwd;
   }

   public String getNickName() {
      return nickName;
   }

   public void setNickName(String nickName) {
      this.nickName = nickName;
   }

   public String getBornDate() {
      return bornDate;
   }

   public void setBornDate(String bornDate) {
      this.bornDate = bornDate;
   }

   public String getEmail() {
      return email;
   }

   public void setEmail(String email) {
      this.email = email;
   }

   public String getDeleteYn() {
      return deleteYn;
   }

   public void setDeleteYn(String deleteYn) {
      this.deleteYn = deleteYn;
   }

   public String getJoinDate() {
      return joinDate;
   }

   public void setJoinDate(String joinDate) {
      this.joinDate = joinDate;
   }

   @Override
   public int hashCode() {
      final int prime = 31;
      int result = 1;
      result = prime * result + ((bornDate == null) ? 0 : bornDate.hashCode());
      result = prime * result + ((deleteYn == null) ? 0 : deleteYn.hashCode());
      result = prime * result + ((email == null) ? 0 : email.hashCode());
      result = prime * result + ((joinDate == null) ? 0 : joinDate.hashCode());
      result = prime * result + ((memId == null) ? 0 : memId.hashCode());
      result = prime * result + memNo;
      result = prime * result + ((memPwd == null) ? 0 : memPwd.hashCode());
      result = prime * result + ((nickName == null) ? 0 : nickName.hashCode());
      return result;
   }

   @Override
   public boolean equals(Object obj) {
      if (this == obj)
         return true;
      if (obj == null)
         return false;
      if (getClass() != obj.getClass())
         return false;
      AdminMember other = (AdminMember) obj;
      if (bornDate == null) {
         if (other.bornDate != null)
            return false;
      } else if (!bornDate.equals(other.bornDate))
         return false;
      if (deleteYn == null) {
         if (other.deleteYn != null)
            return false;
      } else if (!deleteYn.equals(other.deleteYn))
         return false;
      if (email == null) {
         if (other.email != null)
            return false;
      } else if (!email.equals(other.email))
         return false;
      if (joinDate == null) {
         if (other.joinDate != null)
            return false;
      } else if (!joinDate.equals(other.joinDate))
         return false;
      if (memId == null) {
         if (other.memId != null)
            return false;
      } else if (!memId.equals(other.memId))
         return false;
      if (memNo != other.memNo)
         return false;
      if (memPwd == null) {
         if (other.memPwd != null)
            return false;
      } else if (!memPwd.equals(other.memPwd))
         return false;
      if (nickName == null) {
         if (other.nickName != null)
            return false;
      } else if (!nickName.equals(other.nickName))
         return false;
      return true;
   }

   @Override
   public String toString() {
      return "Member [memNo=" + memNo + ", memId=" + memId + ", memPwd=" + memPwd + ", nickName=" + nickName
            + ", bornDate=" + bornDate + ", email=" + email + ", deleteYn=" + deleteYn + ", joinDate=" + joinDate
            + "]";
   }
   
}