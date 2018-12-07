
package benchmark_list;

import java.util.Observable;

/**
 *
 * @author Guest
 */
public class Benchmark_list_ergebnis
{
    private int scoreGPU, scoreCPU, nummer;
    private String besitzer, bGPU, bCPU;
    
    public Benchmark_list_ergebnis(int scoreGPU, int scoreCPU, int nr, String besitzer, String bGPU, String bCPU)
    {
        this.scoreGPU = scoreGPU;
        this.scoreCPU = scoreCPU;
        this.nummer = nr;
        this.besitzer = besitzer;
        this.bGPU = bGPU;
        this.bCPU = bCPU;
    }
    
    public Benchmark_list_ergebnis(int scoreGPU, int scoreCPU, int nr)
    {
        this(scoreGPU, scoreCPU, nr, "Tim Plotzki", "NVIDIA GeForce GTX 1060 6GB" , "Intel Core i5-7400");
    }

    public String getScoreGPU() 
    {
        return Integer.toString(scoreGPU);
    }

    public String getScoreCPU() 
    {
        return Integer.toString(scoreCPU);
    }

    public String getNummer() 
    {
        return Integer.toString(nummer);
    }

    public String getBesitzer() 
    {
        return besitzer;
    }

    public String getbGPU() 
    {
        return bGPU;
    }

    public String getbCPU() 
    {
        return bCPU;
    }
    
    @Override
    public String toString()
    {
        return "Nummer: " + getNummer() + "\n" + "Besitzer: " + getBesitzer() + "\n" + "GPU: " + getScoreGPU() + "\n" + "CPU: " + getScoreCPU() + "\n";
    }
    
    @Override
    public boolean equals(Object arg)
    {
        Benchmark_list_ergebnis obj = arg instanceof Benchmark_list_ergebnis ? (Benchmark_list_ergebnis) arg : null;
        if(obj != null)
            return  obj.getScoreGPU() == this.getScoreGPU() && obj.getScoreCPU() == this.getScoreCPU();
        return false;
    }
    
}
