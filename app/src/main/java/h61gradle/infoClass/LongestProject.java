package h61gradle.infoClass;

public class LongestProject {
   private String name;
   private int monthCount;

   @Override
   public String toString() {
      return "LongestProject{" +
              "name='" + name + '\'' +
              ", monthCount=" + monthCount +
              '}';
   }

   public LongestProject(String name, int monthCount) {
      this.name = name;
      this.monthCount = monthCount;
   }

   public String getName() {
      return name;
   }

   public int getMonthCount() {
      return monthCount;
   }
}
