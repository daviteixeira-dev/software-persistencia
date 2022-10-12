package com.lista.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.lista.entidade.Aluno;

public class AlunoJDBCDAO implements AlunoDAO {

    public AlunoJDBCDAO(){};

    public void inserirAluno(Aluno aluno){
        
        Connection connection = null;
        
        try {
            connection = ConnectionFactory.getConnection();
            
            String insert_sql = "insert into alunos (cpf, nome, email, telefone, matricula) values (?, ?, ?, ?, ?)";
            String update_sql = "update alunos set cpf = ?, nome = ?, email = ?, telefone = ?, matricula = ? where id = ?";
            PreparedStatement pst;

            if (aluno.getId() == 0) {
				pst = connection.prepareStatement(insert_sql);
			} else {
				pst = connection.prepareStatement(update_sql);
				pst.setInt(6, aluno.getId());
			}

            pst.setString(1, aluno.getCpf());
			pst.setString(2, aluno.getNome());
            pst.setString(3, aluno.getEmail());
			pst.setString(4, aluno.getTelefone());
			pst.setString(5, aluno.getMatricula());
			pst.executeUpdate();

        } catch (SQLException e) {
            throw new DAOException("Operação não realizada com sucesso.", e);
        } finally {
			try {
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				throw new DAOException("Não foi possível fechar a conexão.", e);
			}
		}
    }

    public void deletarAluno(int id){
        
        Connection connection = null;
		
        try {

			connection = ConnectionFactory.getConnection();

			String sql = "delete from alunos where id = ?";

			PreparedStatement pst = connection.prepareStatement(sql);

			pst.setInt(1, id);
			pst.executeUpdate();

		} catch (SQLException e) {
			throw new DAOException("Operação não realizada com sucesso.", e);
		} finally {
			try {
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				throw new DAOException("Não foi possível fechar a conexão.",e);
			}
		}
    }

    private Aluno map(ResultSet rs) throws SQLException {
		Aluno aluno = new Aluno();
		aluno.setId(rs.getInt("id"));
		aluno.setCpf(rs.getString("cpf"));
		aluno.setNome(rs.getString("nome"));
        aluno.setEmail(rs.getString("email"));
		aluno.setTelefone(rs.getString("telefone"));
        aluno.setMatricula(rs.getString("matricula"));
		return aluno;
	}

    public Aluno consultarAluno(int id){
        
        Connection connection = null;
		Aluno aluno = null;
		
        try {
			connection = ConnectionFactory.getConnection();
			String sql = "select id, cpf, nome, email, telefone, matricula from alunos where id = ?";

			PreparedStatement pst = connection.prepareStatement(sql);
			pst.setInt(1, id);
			ResultSet rs = pst.executeQuery();

			if (rs.next()) {
				aluno = map(rs);
			}

		} catch (SQLException e) {
			throw new DAOException("Operação não realizada com sucesso.", e);
		} finally {
			try {
				if (connection != null)
                    connection.close();
			} catch (SQLException e) {
				throw new DAOException("Não foi possível fechar a conexão.",e);
			}
		}
		return aluno;
    }

    public List<Aluno> todosAlunos(){

        Connection connection = null;
		List<Aluno> resultado = null;
		
        try {

			connection = ConnectionFactory.getConnection();

			PreparedStatement pst;

			String sql = "select id, cpf, nome, email, telefone, matricula from alunos";
			pst = connection.prepareStatement(sql);

			ResultSet rs = pst.executeQuery();
			resultado = new ArrayList<Aluno>();

			while (rs.next()) {
				Aluno aluno = map(rs);
				resultado.add(aluno);
			}

		} catch (SQLException e) {
			throw new DAOException("Operação não realizada com sucesso.", e);
		} finally {
			try {
				if (connection != null)
                    connection.close();
			} catch (SQLException e) {
				throw new DAOException("Não foi possível fechar a conexão.",e);
			}
		}
		return resultado;
    }

    public Aluno consultarAlunoPeloCPF(String cpf){

        Connection connection = null;
		Aluno alu = null;

		try {
			connection = ConnectionFactory.getConnection();
			PreparedStatement pst;
			String sql = "select id, cpf, nome, email, telefone, matricula from alunos where cpf = ?";
			pst = connection.prepareStatement(sql);

			pst.setString(1, cpf);
			ResultSet rs = pst.executeQuery();

			if (rs.next()) {
				alu = map(rs);
			}
		} catch (SQLException e) {
			throw new DAOException("Operação não realizada com sucesso.", e);
		} finally {
			try {
				if (connection != null)
                    connection.close();
			} catch (SQLException e) {
				throw new DAOException("Não foi possível fechar a conexão.",e);
			}
		}
		return alu;
    }
}
