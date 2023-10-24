import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import java.util.NoSuchElementException;

class ProteinSynthesisTest {
    @Test
    public void test3(){
        ProteinSynthesis test = new ProteinSynthesis();
        CharQueue rna_output = test.transcribeDNA("ATGATCTCGTAA");



        CharQueue protein_output = test.translateRNA(rna_output);

        assertEquals(protein_output.size(), 4);
        assertEquals(protein_output.dequeue(), 'M');
        assertEquals(protein_output.dequeue(), 'I');
        assertEquals(protein_output.dequeue(), 'S');
        assertEquals(protein_output.dequeue(), '*');
        assertEquals(protein_output.size(), 0);


        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            // code that is expected to throw the exception
            CharQueue rna_output2 = test.transcribeDNA("TACAT");
        });

    }
    @Test
    public void test4(){

        ProteinSynthesis test = new ProteinSynthesis();

        CharQueue rna_output = test.transcribeDNA("CCCCTGTCATAA");

        assertEquals(rna_output.size(), 12);
        String output = "";
        int size = rna_output.size();
        for(int i = 0; i<size; i++){
            output = output + rna_output.dequeue();
        }
        assertEquals(output , "CCCCUGUCAUAA");
        assertEquals(rna_output.size(), 0);



    }
    @Test
    public void test5(){

        ProteinSynthesis test = new ProteinSynthesis();

        CharQueue rna_output = test.transcribeDNA("ATGCTATGT");

        assertEquals(rna_output.size(), 9);

        CharQueue protein_output = test.translateRNA(rna_output);

        String output = "";

        int size = protein_output.size();
        for(int i = 0; i<size; i++){
            output = output + protein_output.dequeue();
        }
        assertEquals(output , "MLC");
        assertEquals(rna_output.size(), 0);



    }

}