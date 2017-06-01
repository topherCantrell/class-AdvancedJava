import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;


public class Tinker {

    public static void main(String[] args) {      
        
        ZoneId id = ZoneId.of("lasdfkjlaskdjf");
        
        int i = Calendar.HOUR;
        
       LocalDate date = LocalDate.now();
       
       Period per = Period.ofDays(14);
       
       date = date.plus(per);
       date = date.plus(per);
       
       LocalDateTime dt = LocalDateTime.now();
       
       Duration dur = Duration.ofMinutes(120);
       
       dt = dt.minus(dur);
       

              
       
       
        
        
        

    }

}
