package com.example.votacoes_app;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import com.example.votacoes_app.model.Integrante;
import com.example.votacoes_app.model.Reuniao;
import com.example.votacoes_app.model.ValidaCpf;

public class CpfTest {
    private static Integrante integrante;

    @BeforeClass
    public static void start(){
        integrante = new Integrante();
    }

    @Before
    public void setUp(){
        integrante.setCpf("");
        integrante.setNome("Augusto Rustick");
        integrante.setSenha("Agt3009!");
        integrante.setConselho("CONSUNI");
        integrante.setContato("(48) 9 8417 2199");
        integrante.setTipo(1);
    }

    @After
    public void tearDown() {
        integrante.setCpf("");
    }

    @Test
    public void TestCT001() {
        integrante.setCpf("123456789");
        assert(ValidaCpf.isCpfValid(integrante.getCpf()) == false);
    }

    @Test
    public void TestCT002() {
        integrante.setCpf("1234567891011");
        assert(ValidaCpf.isCpfValid(integrante.getCpf()) == false);
    }

    @Test
    public void TestCT003() {
        integrante.setCpf("12345678910");
        assert(ValidaCpf.isCpfValid(integrante.getCpf()) == false);
    }

    @Test
    public void TestCT004() {
        integrante.setCpf("");
        assert(ValidaCpf.isCpfValid(integrante.getCpf()) == false);
    }

    @Test
    public void TestCT005() {
        integrante.setCpf("07641947980");
        assert(ValidaCpf.isCpfValid(integrante.getCpf()) == true);
    }

}
