package br.com.alura.escola.infra.aluno;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import br.com.alura.escola.dominio.aluno.Aluno;
import br.com.alura.escola.dominio.aluno.CPF;
import br.com.alura.escola.dominio.aluno.Email;
import br.com.alura.escola.dominio.aluno.RepositorioAluno;
import br.com.alura.escola.dominio.aluno.Telefone;

public class RepositorioAlunosJDBC implements RepositorioAluno {

	private final Connection connection;

	public RepositorioAlunosJDBC(Connection connection) {
		super();
		this.connection = connection;
	}

	@Override
	public void matricular(Aluno aluno) {

		try {
			String sql = "INSERT INTO ALUNO VALUES(?,?,?)";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, aluno.getCpf());
			ps.setString(2, aluno.getNome());
			ps.setString(3, aluno.getEmail());
			ps.execute();

			sql = "INSERT INTO TELEFONE VALUES(?,?)";
			ps = connection.prepareStatement(sql);
			for (Telefone telefone : aluno.getTelefones()) {
				ps.setString(1, telefone.getDdd());
				ps.setString(2, telefone.getNumero());
				ps.execute();
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public Aluno buscarPorCPF(CPF cpf) {
		try {
			String sql = "SELECT id, nome, email FROM ALUNO WHERE cpf = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, cpf.getCaracteres());

			ResultSet resultSet = preparedStatement.executeQuery();
			boolean encontrou = resultSet.next();

			String nome = resultSet.getString("nome");
			Email email = new Email(resultSet.getString("email"));
			Aluno encontrado = new Aluno(cpf, nome, email);

			Long id = resultSet.getLong("id");
			sql = "SELECT ddd, numero FROM TELEFONE WHERE aluno_id = ?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setLong(1, id);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				String numero = resultSet.getString("numero");
				String ddd = resultSet.getString("ddd");
				encontrado.adicionarTelefone(ddd, numero);
			}

			return encontrado;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public List<Aluno> listarTodosoOsAlunosMatriculados() {
		// TODO Auto-generated method stub
		return null;
	}

}
