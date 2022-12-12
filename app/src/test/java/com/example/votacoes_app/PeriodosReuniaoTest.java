package com.example.votacoes_app;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import com.example.votacoes_app.model.Reuniao;

import java.util.Objects;

public class PeriodosReuniaoTest {

    private static Reuniao reuniao;

    @BeforeClass
    public static void start(){
        reuniao = new Reuniao();
    }


    @Before
    public void setUp(){
        reuniao.setConselho("CONSELHO");
        reuniao.setLocal("LOCAL");
        reuniao.setQuorum("QUORUM");
        reuniao.setSecretario("SECRETARIO");
        reuniao.setStatus(1);
        reuniao.resetHora();
        reuniao.resetHoraFim();
        reuniao.setData("01/01/01");
    }

    @After
    public void tearDown() {

    }

    @Test
    public void TestCT010() {

        String invalidDate = "ab/cd/ef";
        String invalidTime = "99:99";

        reuniao.setData(invalidDate);
        reuniao.setHora(invalidTime);

        String date = reuniao.getData();
        String time = reuniao.getHora();
        assert(date == null & time == null);

    }

    @Test
    public void TestCT011() {

        String emptyDate = "";
        String emptyTime = "";

        reuniao.setData(emptyDate);
        reuniao.setHora(emptyTime);

        String date = reuniao.getData();
        String time = reuniao.getHora();
        assert(date == null & time == null);

    }

    @Test
    public void TestCT012() {
        String validDate = "21/12/22";
        String validTime = "12:00";

        reuniao.setData(validDate);
        reuniao.setHora(validTime);

        String date = reuniao.getData();
        String time = reuniao.getHora();

        assert(date.equals(validDate) & time.equals(validTime));
    }

    @Test
    public void TestCT045() {
        String invalidTime = "12:00";
        String validTimeEnd = "11:00";

        reuniao.setHora(invalidTime);
        reuniao.setHoraFim(validTimeEnd);

        String time;
        String timeEnd = reuniao.getHoraFim();

        assert(timeEnd == null);
    }

    @Test
    public void TestCT046() {
        String invalidTime = "12:00";
        String validTimeEnd = "12:00";

        reuniao.setHora(invalidTime);
        reuniao.setHoraFim(validTimeEnd);

        String time;
        String timeEnd = reuniao.getHoraFim();

        assert(timeEnd == null);
    }

    @Test
    public void TestCT047() {
        String invalidTime = "12:00";
        String validTimeEnd = "12:00";
        // Limiar == 0

        reuniao.setHora(invalidTime);
        reuniao.setHoraFim(validTimeEnd);

        String timeEnd = reuniao.getHoraFim();

        assert(timeEnd == null);
    }

    @Test
    public void TestCT048() {
        String invalidTime = "12:00";
        String validTimeEnd = "12:10";

        reuniao.setHora(invalidTime);
        reuniao.setHoraFim(validTimeEnd);

        String timeEnd = reuniao.getHoraFim();

        assert(timeEnd.equals(validTimeEnd));
    }

}

