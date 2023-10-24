/*
    Name: TODO
    PID:  TODO
 */

/**
 * TODO
 *
 * @author Eli Nalebuff
 * @since 2023.10.21
 */
class ProteinSynthesis {

    // transcribes DNA into RNA, if the input is not divisible by 3, it will throw an error
    public CharQueue transcribeDNA(String dna) {
        if (dna.length()%3!=0){
            throw new IllegalArgumentException();

        }
        CharQueue dna_queue = new CharQueue(dna.length());
        for(int i = 0; i<dna.length(); i++){
            if (dna.charAt(i)== 'T'){
                dna_queue.enqueue('U');

            }
            else{
                dna_queue.enqueue(dna.charAt(i));
            }
        }
        return dna_queue;
    }
    //Takes in a queue and translates it using the Codon map function. Only transcribes
    // after it sees "AUG" and stops if it sees "UAA" "UAG" "UGA"
    public CharQueue translateRNA(CharQueue rna) {
        boolean start = false;
        boolean end = false;
        CharQueue protein = new CharQueue();
        while(start == false && !rna.isEmpty()){
            String rna_strand = "" + rna.dequeue() + rna.dequeue() + rna.dequeue();
            if (rna_strand.equals("AUG")){
                start = true;
                protein.enqueue(CodonMap.getAminoAcid(rna_strand));
            }
        }
        while(start == true && end == false && !rna.isEmpty()){
            String rna_strand = "" + rna.dequeue() + rna.dequeue() + rna.dequeue();
            if (rna_strand.equals("UAA") || rna_strand.equals("UAG") || rna_strand.equals("UGA") ){
                end = true;
            }
            protein.enqueue(CodonMap.getAminoAcid(rna_strand));
        }
        return protein;
    }

}