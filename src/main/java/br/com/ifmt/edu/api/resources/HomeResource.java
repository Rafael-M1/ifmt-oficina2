package br.com.ifmt.edu.api.resources;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import br.com.ifmt.edu.api.model.Aluno;
import br.com.ifmt.edu.api.model.AtividadeComplementar;
import br.com.ifmt.edu.api.model.TipoAtividade;
import br.com.ifmt.edu.api.services.AlunoService;
import br.com.ifmt.edu.api.services.AtividadeComplementarService;
import br.com.ifmt.edu.api.services.TipoAtividadeService;

@Controller
@RequestMapping("/")
public class HomeResource {

	@Autowired
	private TipoAtividadeService tipoAtividadeService;

	@Autowired
	private AlunoService alunoService;

	@Autowired
	private AtividadeComplementarService atividadeComplementarService;

	@GetMapping()
	public String home() {
		return "redirect:/home";
	}

	@GetMapping("/home")
	public String mostrarPaginaHome() {
		return "home/index.html";
	}

	// Aluno
	@GetMapping("/cadastro/aluno")
	public String mostrarPaginaListaAluno(Model model) {
		List<Aluno> alunos = alunoService.buscarTodos();
		model.addAttribute("alunos", alunos);
		return "cadastro/aluno/index.html";
	}

	@GetMapping("/cadastro/aluno/novo")
	public String mostrarPaginaCadastroAluno(Model model) {
		Aluno aluno = new Aluno();
		model.addAttribute("aluno", aluno);
		return "cadastro/aluno/adicionarAluno.html";
	}

	@GetMapping("/cadastro/aluno/alterar/{id}")
	public String mostrarPaginaAlterarAluno(Model model, @PathVariable Long id) {
		Aluno aluno = alunoService.buscarPorId(id);
		model.addAttribute("aluno", aluno);
		return "cadastro/aluno/adicionarAluno.html";
	}

	// Método para fazer um update em um aluno já existente ou salvar um novo aluno
	@PostMapping("/cadastro/aluno/novo")
	public String salvarAluno(@ModelAttribute Aluno aluno, Model model) {
		if (aluno.getAlunoId() != null) {
			alunoService.atualizar(aluno);
			model.addAttribute("aluno", aluno);
			return "redirect:/cadastro/aluno?alterarSucesso";
		}
		alunoService.salvar(aluno);
		model.addAttribute("aluno", aluno);
		return "redirect:/cadastro/aluno?cadastroSucesso";
	}

	// Método para fazer um delete de um aluno já existente
	@GetMapping("/cadastro/aluno/deletar/{id}")
	public String deletarAluno(@PathVariable Long id, Model model) {
		if (alunoService.buscarPorId(id) != null) {
			alunoService.deletar(id);
			return "redirect:/cadastro/aluno?deletarSucesso";
		}
		return "redirect:/cadastro/aluno?deletarFalha";
	}

	//
	// Tipo Atividade
	@GetMapping("/cadastro/tipoatividade")
	public String mostrarPaginaListaTipoAtividade(Model model) {
		List<TipoAtividade> tipoatividades = tipoAtividadeService.buscarTodos();
		model.addAttribute("tipoatividades", tipoatividades);
		return "cadastro/tipoatividade/index.html";
	}

	@GetMapping("/cadastro/tipoatividade/novo")
	public String mostrarPaginaCadastroTipoAtividade(Model model) {
		TipoAtividade tipoAtividade = new TipoAtividade();
		model.addAttribute("tipoAtividade", tipoAtividade);
		return "cadastro/tipoatividade/adicionarTipoAtividade.html";
	}

	@GetMapping("/cadastro/tipoatividade/alterar/{id}")
	public String mostrarPaginaAlterarTipoAtividade(Model model, @PathVariable Long id) {
		TipoAtividade tipoAtividade = tipoAtividadeService.buscarPorId(id);
		model.addAttribute("tipoAtividade", tipoAtividade);
		return "cadastro/tipoatividade/adicionarTipoAtividade.html";
	}

	// Método para fazer um update em um tipoatividade já existente ou salvar um
	// novo tipoatividade
	@PostMapping("/cadastro/tipoatividade/novo")
	public String salvarTipoAtividade(@ModelAttribute TipoAtividade tipoAtividade, Model model) {
		if (tipoAtividade.getTipoAtividadeId() != null) {
			tipoAtividadeService.atualizar(tipoAtividade);
			model.addAttribute("tipoAtividade", tipoAtividade);
			return "redirect:/cadastro/tipoatividade?alterarSucesso";
		}
		tipoAtividadeService.salvar(tipoAtividade);
		model.addAttribute("tipoAtividade", tipoAtividade);
		return "redirect:/cadastro/tipoatividade?cadastroSucesso";
	}

	// Método para fazer um delete de um tipoatividade já existente
	@GetMapping("/cadastro/tipoatividade/deletar/{id}")
	public String deletarTipoAtividade(@PathVariable Long id, Model model) {
		if (tipoAtividadeService.buscarPorId(id) != null) {
			tipoAtividadeService.deletar(id);
			return "redirect:/cadastro/tipoatividade?deletarSucesso";
		}
		return "redirect:/cadastro/tipoatividade?deletarFalha";
	}

	//
	// Atividade Complementar
	@GetMapping("/cadastro/atividadecomplementar")
	public String mostrarPaginaListaAtividadeComplementar(Model model) {
		List<AtividadeComplementar> atividades = atividadeComplementarService.buscarTodos();
		model.addAttribute("atividades", atividades);
		return "cadastro/atividadecomplementar/index.html";
	}

	@GetMapping("/cadastro/atividadecomplementar/novo")
	public String mostrarPaginaCadastroAtividadeComplementar(Model model) {
		AtividadeComplementar atividadeComplementar = new AtividadeComplementar();
		List<Aluno> listaAlunos = alunoService.buscarTodos();
		List<TipoAtividade> listaTipoAtividades = tipoAtividadeService.buscarTodos();
		model.addAttribute("atividadeComplementar", atividadeComplementar);
		model.addAttribute("listaAlunos", listaAlunos);
		model.addAttribute("listaTipoAtividades", listaTipoAtividades);
		return "cadastro/atividadecomplementar/adicionarAtividadeComplementar.html";
	}

	@GetMapping("/cadastro/atividadecomplementar/alterar/{id}")
	public String mostrarPaginaAlterarAtividadeComplementar(Model model, @PathVariable Long id) {
		AtividadeComplementar atividadeComplementar = atividadeComplementarService.buscarPorId(id);
		List<Aluno> listaAlunos = alunoService.buscarTodos();
		List<TipoAtividade> listaTipoAtividades = tipoAtividadeService.buscarTodos();
		model.addAttribute("atividadeComplementar", atividadeComplementar);
		model.addAttribute("listaAlunos", listaAlunos);
		model.addAttribute("listaTipoAtividades", listaTipoAtividades);
		return "cadastro/atividadecomplementar/adicionarAtividadeComplementar.html";
	}

	// Método para fazer um update em um atividadecomplementar já existente ou salvar um
	// novo atividadecomplementar
	@PostMapping("/cadastro/atividadecomplementar/novo")
	public String salvarAtividadeComplementar(
			@ModelAttribute("atividadeComplementar") AtividadeComplementar atividadeComplementar,
			@RequestParam("arquivo") MultipartFile arquivo, Model model) throws IOException {
		if (atividadeComplementar.getAtividadeComplementarId() != null) {
			atividadeComplementarService.atualizar(atividadeComplementar);
			return "redirect:/cadastro/atividadecomplementar?alterarSucesso";
		}
		atividadeComplementarService.salvar(atividadeComplementar);
		model.addAttribute("atividadeComplementar", atividadeComplementar);
		return "redirect:/cadastro/atividadecomplementar?cadastroSucesso";
	}

	// Método para fazer o download do arquivo de atividade complementar
	@GetMapping("/cadastro/atividadecomplementar/download/{id}")
	public String downloadArquivoAtividadeComplementar(Model model, @PathVariable Long id) {
		String base64String = atividadeComplementarService.downloadImagem(id);
		model.addAttribute("arquivo", base64String);
		return "cadastro/atividadecomplementar/visualizarArquivo.html";
	}

	// Método para fazer um delete de um AtividadeComplementar já existente
	@GetMapping("/cadastro/atividadecomplementar/deletar/{id}")
	public String deletarAtividadeComplementar(@PathVariable Long id, Model model) {
		if (atividadeComplementarService.buscarPorId(id) != null) {
			atividadeComplementarService.deletar(id);
			return "redirect:/cadastro/atividadecomplementar?deletarSucesso";
		}
		return "redirect:/cadastro/atividadecomplementar?deletarFalha";
	}
}
