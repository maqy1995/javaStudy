import java.time.LocalDateTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class timeTest {
    public static void main(String[] args) {
        LocalDateTime ldt = LocalDateTime.now();

        //关联到当前默认时区
        ZonedDateTime bj = ldt.atZone(ZoneId.of("Asia/Shanghai"));

        System.out.println(bj);

        ZonedDateTime ny = bj.withZoneSameInstant(ZoneId.of("America/New_York"));
        System.out.println(ny);

    }
}
