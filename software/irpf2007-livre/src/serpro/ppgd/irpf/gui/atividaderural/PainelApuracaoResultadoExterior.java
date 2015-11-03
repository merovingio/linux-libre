/* PainelApuracaoResultadoExterior - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */
package serpro.ppgd.irpf.gui.atividaderural;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

import org.jdesktop.layout.GroupLayout;

import serpro.ppgd.app.PgdIRPF;
import serpro.ppgd.gui.xbeans.JEditValor;
import serpro.ppgd.infraestrutura.PlataformaPPGD;
import serpro.ppgd.irpf.gui.PainelIRPFIf;
import serpro.ppgd.irpf.gui.util.IRPFGuiUtil;

public class PainelApuracaoResultadoExterior extends JPanel implements PainelIRPFIf
{
  private static final String TITULO = "Apura\u00e7\u00e3o do Resultado - Exterior";
  private JEditValor jEditValor1;
  private JEditValor jEditValor10;
  private JEditValor jEditValor11;
  private JEditValor jEditValor2;
  private JEditValor jEditValor4;
  private JEditValor jEditValor5;
  private JEditValor jEditValor6;
  private JEditValor jEditValor7;
  private JEditValor jEditValor8;
  private JEditValor jEditValor9;
  private JLabel jLabel1;
  private JLabel jLabel10;
  private JLabel jLabel11;
  private JLabel jLabel14;
  private JLabel jLabel15;
  private JLabel jLabel16;
  private JLabel jLabel2;
  private JLabel jLabel3;
  private JLabel jLabel5;
  private JLabel jLabel6;
  private JLabel jLabel7;
  private JLabel jLabel8;
  private JLabel jLabel9;
  
  public String getTituloPainel ()
  {
    return "Apura\u00e7\u00e3o do Resultado - Exterior";
  }
  
  public PainelApuracaoResultadoExterior ()
  {
    PlataformaPPGD.getPlataforma ().setHelpID (this, "ARResultado");
    initComponents ();
    Font f = PgdIRPF.FONTE_DEFAULT;
    f = f.deriveFont (1);
    f = f.deriveFont (f.getSize2D () + 1.0F);
    IRPFGuiUtil.setaFonteTodosLabelContainer (this, f);
  }
  
  private void initComponents ()
  {
    jLabel1 = new JLabel ();
    jLabel2 = new JLabel ();
    jEditValor1 = new JEditValor ();
    jLabel3 = new JLabel ();
    jEditValor2 = new JEditValor ();
    jLabel5 = new JLabel ();
    jEditValor4 = new JEditValor ();
    jLabel6 = new JLabel ();
    jEditValor5 = new JEditValor ();
    jLabel7 = new JLabel ();
    jEditValor6 = new JEditValor ();
    jLabel8 = new JLabel ();
    jEditValor7 = new JEditValor ();
    jLabel9 = new JLabel ();
    jLabel10 = new JLabel ();
    jEditValor8 = new JEditValor ();
    jLabel11 = new JLabel ();
    jEditValor9 = new JEditValor ();
    jLabel14 = new JLabel ();
    jLabel15 = new JLabel ();
    jEditValor10 = new JEditValor ();
    jLabel16 = new JLabel ();
    jEditValor11 = new JEditValor ();
    jLabel1.setText ("<HTML><B>APURA\u00c7\u00c3O DO RESULTADO TRIBUT\u00c1VEL</B></HTML>");
    jLabel2.setText ("<HTML><B>01. Resultado I - US$</B></HTML>");
    jEditValor1.setAceitaFoco (false);
    jEditValor1.setInformacaoAssociada ("atividadeRural.exterior.apuracaoResultado.resultadoI_EmDolar");
    jLabel3.setText ("<HTML><B>02. Resultado I - R$ (Linha 01 multiplicada por 2,1372)</B></HTML>");
    jEditValor2.setAceitaFoco (false);
    jEditValor2.setInformacaoAssociada ("atividadeRural.exterior.apuracaoResultado.resultadoI_EmReais");
    jLabel5.setText ("<HTML><B>03. Preju\u00edzo de exerc\u00edcio anterior - R$</B></HTML>");
    jEditValor4.setInformacaoAssociada ("atividadeRural.exterior.apuracaoResultado.prejuizoExercicioAnterior");
    jLabel6.setText ("<HTML><B>04. Resultado ap\u00f3s compensa\u00e7\u00e3o do preju\u00edzo - R$</B></HTML>");
    jEditValor5.setAceitaFoco (false);
    jEditValor5.setInformacaoAssociada ("atividadeRural.exterior.apuracaoResultado.resultadoAposCompensacaoPrejuizo");
    jLabel7.setText ("<HTML><B>05. Op\u00e7\u00e3o pelo arbitramento sobre a receita bruta - R$</B></HTML>");
    jEditValor6.setInformacaoAssociada ("atividadeRural.exterior.apuracaoResultado.opcaoArbitramento");
    jLabel8.setText ("<HTML><B>06. <U>Resultado tribut\u00e1vel - R$</U></B></HTML>");
    jEditValor7.setAceitaFoco (false);
    jEditValor7.setInformacaoAssociada ("atividadeRural.exterior.apuracaoResultado.resultadoTributavel");
    jLabel9.setText ("<HTML><B>INFORMA\u00c7\u00d5ES PARA O EXERC\u00cdCIO SEGUINTE</B></HTML>");
    jLabel9.setVerticalAlignment (3);
    jLabel10.setText ("<HTML><B>07. Preju\u00edzo a compensar - R$</B></HTML>");
    jEditValor8.setAceitaFoco (false);
    jEditValor8.setInformacaoAssociada ("atividadeRural.exterior.apuracaoResultado.prejuizoCompensar");
    jLabel11.setText ("<HTML><B>08. Valor dos adiantamentos recebidos em 2006 por conta de venda para entrega futura - R$</B></HTML>");
    jEditValor9.setInformacaoAssociada ("atividadeRural.exterior.apuracaoResultado.receitaRecebidaContaVenda");
    jLabel14.setText ("<HTML><B>APURA\u00c7\u00c3O DO RESULTADO N\u00c3O-TRIBUT\u00c1VEL</B></HTML>");
    jLabel14.setVerticalAlignment (3);
    jLabel15.setText ("<HTML><B>09. Valor dos adiantamentos recebidos at\u00e9 2005 referente a produtos entregues em 2006 - R$</B></HTML>");
    jEditValor10.setInformacaoAssociada ("atividadeRural.exterior.apuracaoResultado.valorAdiantamento");
    jLabel16.setText ("<HTML><B>10. <U>Resultado n\u00e3o-tribut\u00e1vel - R$</U></B></HTML>");
    jEditValor11.setAceitaFoco (false);
    jEditValor11.setInformacaoAssociada ("atividadeRural.exterior.apuracaoResultado.resultadoNaoTributavel");
    GroupLayout layout = new GroupLayout (this);
    setLayout (layout);
    layout.setHorizontalGroup (layout.createParallelGroup (1).add (layout.createSequentialGroup ().addContainerGap ().add (layout.createParallelGroup (1).add (jLabel1).add (layout.createSequentialGroup ().add (jLabel14, -1, 252, 32767).add (299, 299, 299)).add (layout.createSequentialGroup ().add (jLabel9, -1, 246, 32767).add (305, 305, 305)).add (2, layout.createSequentialGroup ().add (layout.createParallelGroup (1).add (jLabel15, -1, 417, 32767).add (jLabel11, -1, 417, 32767).add (jLabel2).add (layout.createSequentialGroup ().add (jLabel3, -1, -1, 32767).add (111, 111, 111)).add (layout.createSequentialGroup ().add (jLabel5, -1, -1, 32767).add (205, 205, 205)).add (layout.createSequentialGroup ().add (jLabel6, -1, -1, 32767).add (137, 137, 137)).add (layout.createSequentialGroup ().add (jLabel7, -1, -1, 32767).add (108, 108, 108)).add (layout.createSequentialGroup ().add (jLabel8, -1, -1, 32767).add (255, 255, 255)).add (jLabel16, -1, 417, 32767).add (jLabel10, -1, 417, 32767)).addPreferredGap (0).add (layout.createParallelGroup (1, false).add (jEditValor10, -1, 128, 32767).add (jEditValor9, -1, 128, 32767).add (jEditValor8, -1, 128, 32767).add (jEditValor7, -1, 128, 32767).add (jEditValor6, -1, 128, 32767).add (jEditValor5, -1, 128, 32767).add (2, jEditValor11, -1, 128, 32767).add (2, jEditValor4, -1, 128, 32767).add (jEditValor2, -1, 128, 32767).add (jEditValor1, -1, 128, 32767)))).addContainerGap ()));
    layout.setVerticalGroup (layout.createParallelGroup (1).add (layout.createSequentialGroup ().addContainerGap ().add (layout.createParallelGroup (2).add (jEditValor1, -2, -1, -2).add (layout.createSequentialGroup ().add (jLabel1).addPreferredGap (0).add (jLabel2))).addPreferredGap (0).add (layout.createParallelGroup (2).add (jLabel3).add (jEditValor2, -2, -1, -2)).addPreferredGap (0).add (layout.createParallelGroup (2).add (jLabel5).add (jEditValor4, -2, -1, -2)).addPreferredGap (0).add (layout.createParallelGroup (2).add (jLabel6).add (jEditValor5, -2, -1, -2)).addPreferredGap (0).add (layout.createParallelGroup (2).add (jLabel7).add (jEditValor6, -2, -1, -2)).addPreferredGap (0).add (layout.createParallelGroup (2).add (jLabel8).add (jEditValor7, -2, -1, -2)).addPreferredGap (0).add (layout.createParallelGroup (2).add (layout.createSequentialGroup ().add (jLabel9, -2, 25, -2).addPreferredGap (0).add (jLabel10)).add (jEditValor8, -2, -1, -2)).addPreferredGap (0).add (layout.createParallelGroup (1).add (jEditValor9, -2, -1, -2).add (jLabel11)).addPreferredGap (0).add (jLabel14, -2, 23, -2).addPreferredGap (0).add (layout.createParallelGroup (1).add (jEditValor10, -2, -1, -2).add (jLabel15, -2, 38, -2)).addPreferredGap (0).add (layout.createParallelGroup (1).add (jEditValor11, -2, -1, -2).add (jLabel16)).addContainerGap (23, 32767)));
  }
  
  public void vaiExibir ()
  {
    /* empty */
  }
  
  public void painelExibido ()
  {
    /* empty */
  }
}