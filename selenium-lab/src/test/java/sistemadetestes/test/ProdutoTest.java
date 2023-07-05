package sistemadetestes.test;

import static org.junit.Assert.assertEquals;

/**
 * Classe de teste criada para verificar coberturas sobre a página de produtos
 * 
 * @author Diego Morais dos Santos Terra
 * @date 05/07/2023
 * 
 */

import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import sistemadetestes.pageObject.ProdutoPO;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ProdutoTest extends BaseTest {
	
	private static ProdutoPO produtoPage;
	
	

	@BeforeClass
	public static void prepararTestes() {
		produtoPage = new ProdutoPO(driver);
	}
	
	
	@Test
	public void TC001_naoDeveCriarProdutosComCamposEmBranco() {
		
		produtoPage.executarAcaoDeCriarProduto("", "", "", "", "");		
		
		String mensagem = produtoPage.obterMensagem();
		
		//Verificação e análise - assert
		assertEquals(mensagem, "Todos os campos são obrigatórios para o cadastro!");
		
	}
	
	@Test
	public void TC002_criacaoDeProdutosComSucesso() {
		
		produtoPage.executarAcaoDeCriarProduto("001", "Mouse", "10", "100", "2023-07-04");
		produtoPage.buttonSair.click();
		
		String codigo = produtoPage.obterCodigo();
		
		assertEquals("001", codigo);
		
	}
	
	@Test
	public void TC003_naoDeveCriarProdutosComCampoCodigoEmBranco() {
		
		produtoPage.executarAcaoDeCriarProduto("", "Mouse", "10", "100", "2023-07-04");
		
		String mensagem = produtoPage.obterMensagem();
		
		assertEquals(mensagem, "Todos os campos são obrigatórios para o cadastro!");
	}

}
