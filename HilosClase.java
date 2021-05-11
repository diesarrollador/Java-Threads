/**
 *
 * @author Diesarrollador
 */
public class HilosClase extends Thread{
    private int [] lista;
    private int num_hilo;
    
    public HilosClase(int [] lista_num, int num_hilo){
        this.lista=lista_num;
        this.num_hilo = num_hilo;
    }
    
    @Override
    public void run(){
        int aux=0;
        for(int i=0;i<this.lista.length;i++){
            aux+=lista[i];
            if((i%100000)==0){
                System.out.println("Resultado parcial del hilo"+this.num_hilo+":"+aux);
            }
        }
        System.out.println("Hilo"+this.num_hilo+":"+aux);
    }
    
    public static int[] generar_lista (int num_elementos){
        int [] lista = new int[num_elementos];
        for (int i = 0; i < num_elementos; i++) {
            lista[i] = (int)(Math.random()*100);
        }
        return lista;
    }

    public static void main(String[] args) {
          int[] listaUno = generar_lista(100);
          int[] listaDos = generar_lista(100);

          HilosClase hilo1 = new HilosClase( listaUno, 1 );
          HilosClase hilo2 = new HilosClase( listaDos, 2 );

          hilo1.start();                                        
          hilo2.start();

  }
}