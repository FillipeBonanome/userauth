package br.com.ms.fillipebonanome.userauth.domain.entities;

import br.com.ms.fillipebonanome.userauth.domain.exceptions.UserException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class UserTest {

    @Test
    public void shouldNotRegisterUserWithNullId() {
        User user = new User();
        Assertions.assertThrows(UserException.class, () -> {
            user.setId(null);
        });
    }

    @Test
    public void shouldNotRegisterUserWithBlankName() {
        User user = new User();
        Assertions.assertThrows(UserException.class, () -> {
           user.setName("");
        });
    }

    @Test
    public void shouldNotRegisterUserWithNullName() {
        User user = new User();
        Assertions.assertThrows(UserException.class, () -> {
            user.setName(null);
        });
    }

    @Test
    public void shouldNotRegisterUserWithNullUsername() {
        User user = new User();
        Assertions.assertThrows(UserException.class, () -> {
            user.setUsername(null);
        });
    }

    @Test
    public void shouldNotRegisterUserWithBlankUsername() {
        User user = new User();
        Assertions.assertThrows(UserException.class, () -> {
            user.setUsername("");
        });
    }

    @Test
    public void shouldNotRegisterUserWithSmallUsername() {
        User user = new User();
        Assertions.assertThrows(UserException.class, () -> {
            user.setUsername("duc1@");
        });
    }

    @Test
    public void shouldNotRegisterUserWithMissingNumberUsername() {
        User user = new User();
        Assertions.assertThrows(UserException.class, () -> {
            user.setUsername("duck_god@");
        });
    }

    @Test
    public void shouldRegisterUserWithGoodUsername() {
        User user = new User();
        Assertions.assertAll(
                () -> {
                    Assertions.assertDoesNotThrow(() -> user.setUsername("Duck1234!"));
                    Assertions.assertDoesNotThrow(() -> user.setUsername("MrQuack1"));
                    Assertions.assertDoesNotThrow(() -> user.setUsername("Username@1"));
                    Assertions.assertDoesNotThrow(() -> user.setUsername("username@1"));
                    Assertions.assertDoesNotThrow(() -> user.setUsername("asqwewqw12323124"));
                    Assertions.assertDoesNotThrow(() -> user.setUsername("qwertyui1"));
                }
        );
    }

    @Test
    public void shouldNotRegisterUserWithNullPassword() {
        User user = new User();
        Assertions.assertThrows(UserException.class, () -> {
            user.setPassword(null);
        });
    }

    @Test
    public void shouldNotRegisterUserWithBlankPassword() {
        User user = new User();
        Assertions.assertThrows(UserException.class, () -> {
            user.setPassword("");
        });
    }

    @Test
    public void shouldNotRegisterUserWithSmallPassword() {
        User user = new User();
        Assertions.assertThrows(UserException.class, () -> {
            user.setPassword("123@a");
        });
    }

    @Test
    public void shouldRegisterUserWithValidPassword() {
        User user = new User();
        Assertions.assertDoesNotThrow(
                () -> user.setPassword("S3nh@Forte!")
        );
        Assertions.assertDoesNotThrow(() -> user.setPassword("P@ssw0rd!_1"));
        Assertions.assertDoesNotThrow(() -> user.setPassword("CleanArc#101"));
        Assertions.assertDoesNotThrow(() -> user.setPassword("Backend_24@"));
        Assertions.assertDoesNotThrow(() -> user.setPassword("Java@Devs_8"));
        Assertions.assertDoesNotThrow(() -> user.setPassword("M1croServ1co!"));
        Assertions.assertDoesNotThrow(() -> user.setPassword("P@ss_Cod3"));
        Assertions.assertDoesNotThrow(() -> user.setPassword("B@n@n@123!"));
        Assertions.assertDoesNotThrow(() -> user.setPassword("Secure#C0d3"));
        Assertions.assertDoesNotThrow(() -> user.setPassword("Aprovado_99$"));
        Assertions.assertDoesNotThrow(() -> user.setPassword("user_2024!"));
        Assertions.assertDoesNotThrow(() -> user.setPassword("MyP@ss#1"));
        Assertions.assertDoesNotThrow(() -> user.setPassword("Pudim#456_"));
        Assertions.assertDoesNotThrow(() -> user.setPassword("Spring*Boot_1"));
        Assertions.assertDoesNotThrow(() -> user.setPassword("Frontend_3!"));
        Assertions.assertDoesNotThrow(() -> user.setPassword("DevOps_55&"));
        Assertions.assertDoesNotThrow(() -> user.setPassword("D@tabase!@_1"));
        Assertions.assertDoesNotThrow(() -> user.setPassword("Python_Ninja$8"));
        Assertions.assertDoesNotThrow(() -> user.setPassword("Golang#Dev_9"));
        Assertions.assertDoesNotThrow(() -> user.setPassword("Nodejs_20@25"));
        Assertions.assertDoesNotThrow(() -> user.setPassword("Kubernetes!_3"));
        Assertions.assertDoesNotThrow(() -> user.setPassword("DockeR_7!#"));
        Assertions.assertDoesNotThrow(() -> user.setPassword("SQL_SERVER!5_"));
        Assertions.assertDoesNotThrow(() -> user.setPassword("NoSQL#3*3"));
        Assertions.assertDoesNotThrow(() -> user.setPassword("Postgres_5@!"));
        Assertions.assertDoesNotThrow(() -> user.setPassword("MongoDB!_2023"));
    }

    @Test
    public void shouldNotRegisterUserWithInvalidEmail() {
        User user = new User();
        Assertions.assertThrows(UserException.class, () -> user.setEmail("usuario.com"));
        Assertions.assertThrows(UserException.class, () -> user.setEmail("usuario@.com"));
        Assertions.assertThrows(UserException.class, () -> user.setEmail("usuario@dominio"));
        Assertions.assertThrows(UserException.class, () -> user.setEmail("usuario@dominio.c"));
        Assertions.assertThrows(UserException.class, () -> user.setEmail("email com espaco@dominio.com"));
        Assertions.assertThrows(UserException.class, () -> user.setEmail("usuario@dominio.com."));
        Assertions.assertThrows(UserException.class, () -> user.setEmail("dominio.com"));
        Assertions.assertThrows(UserException.class, () -> user.setEmail("usuário@dominio.com"));
        Assertions.assertThrows(UserException.class, () -> user.setEmail("email_invalido@.com"));
        Assertions.assertThrows(UserException.class, () -> user.setEmail("email@123.456.789.12345"));
        Assertions.assertThrows(UserException.class, () -> user.setEmail("email@dom.co.uk."));
        Assertions.assertThrows(UserException.class, () -> user.setEmail("outroemail@email"));
        Assertions.assertThrows(UserException.class, () -> user.setEmail("a@b"));
        Assertions.assertThrows(UserException.class, () -> user.setEmail("email@dominio-"));
        Assertions.assertThrows(UserException.class, () -> user.setEmail("email@.com"));
        Assertions.assertThrows(UserException.class, () -> user.setEmail("user@example_domain"));
        Assertions.assertThrows(UserException.class, () -> user.setEmail("email@123"));
        Assertions.assertThrows(UserException.class, () -> user.setEmail("email@123.456.789"));
    }

    @Test
    public void shouldRegisterUserWithValidEmail() {
        User user = new User();
        Assertions.assertDoesNotThrow(() -> user.setEmail("usuario.teste@dominio.com"));
        Assertions.assertDoesNotThrow(() -> user.setEmail("fulano123@email.net"));
        Assertions.assertDoesNotThrow(() -> user.setEmail("dev_java@servidor.com.br"));
        Assertions.assertDoesNotThrow(() -> user.setEmail("nome.sobrenome@organizacao.org"));
        Assertions.assertDoesNotThrow(() -> user.setEmail("contato@site.dev"));
        Assertions.assertDoesNotThrow(() -> user.setEmail("user-1@mail.info"));
        Assertions.assertDoesNotThrow(() -> user.setEmail("meu.email+tag@gmail.com"));
        Assertions.assertDoesNotThrow(() -> user.setEmail("a@b.co"));
        Assertions.assertDoesNotThrow(() -> user.setEmail("outro_email@servico.tech"));
        Assertions.assertDoesNotThrow(() -> user.setEmail("joao.silva@meudominio.app"));
        Assertions.assertDoesNotThrow(() -> user.setEmail("teste.123@site.com"));
        Assertions.assertDoesNotThrow(() -> user.setEmail("user_api@backend.io"));
        Assertions.assertDoesNotThrow(() -> user.setEmail("aluno.a@universidade.edu.br"));
        Assertions.assertDoesNotThrow(() -> user.setEmail("hello-world@example.net"));
        Assertions.assertDoesNotThrow(() -> user.setEmail("web.dev@agencia.design"));
        Assertions.assertDoesNotThrow(() -> user.setEmail("vendas@lojaonline.shop"));
        Assertions.assertDoesNotThrow(() -> user.setEmail("suporte@empresa-x.com"));
        Assertions.assertDoesNotThrow(() -> user.setEmail("gestor.projeto@pro.org"));
        Assertions.assertDoesNotThrow(() -> user.setEmail("contato-legal@business.me"));
        Assertions.assertDoesNotThrow(() -> user.setEmail("info@portal.global"));
        Assertions.assertDoesNotThrow(() -> user.setEmail("usuario.testador.abc@site.com.br"));
        Assertions.assertDoesNotThrow(() -> user.setEmail("admin-@admin.com"));
        Assertions.assertDoesNotThrow(() -> user.setEmail("name.last@domain.com"));
        Assertions.assertDoesNotThrow(() -> user.setEmail("foo@bar.com"));
        Assertions.assertDoesNotThrow(() -> user.setEmail("email_com_underline@exemplo.com"));
        Assertions.assertDoesNotThrow(() -> user.setEmail("email+com.ponto@dom.br"));
        Assertions.assertDoesNotThrow(() -> user.setEmail("dev-spring-boot@email.io"));
        Assertions.assertDoesNotThrow(() -> user.setEmail("fulaninho.de.tal@provedor.online"));
        Assertions.assertDoesNotThrow(() -> user.setEmail("teste123@teste-empresa.com"));
        Assertions.assertDoesNotThrow(() -> user.setEmail("api-user_1@api-gateway.com"));
        Assertions.assertDoesNotThrow(() -> user.setEmail("no-reply@notificacao.com"));
        Assertions.assertDoesNotThrow(() -> user.setEmail("email.comercial@minha-loja.com"));
        Assertions.assertDoesNotThrow(() -> user.setEmail("suporte-tecnico@servicos.com"));
        Assertions.assertDoesNotThrow(() -> user.setEmail("cliente_vip@clientes.pro"));
        Assertions.assertDoesNotThrow(() -> user.setEmail("admin@dominio.test"));
        Assertions.assertDoesNotThrow(() -> user.setEmail("primeiro.nome@empresa.com"));
        Assertions.assertDoesNotThrow(() -> user.setEmail("nomedeusuario@servidor.com"));
        Assertions.assertDoesNotThrow(() -> user.setEmail("abc.xyz@minha-empresa.com.br"));
        Assertions.assertDoesNotThrow(() -> user.setEmail("email_completo@exemplo.com.ar"));
        Assertions.assertDoesNotThrow(() -> user.setEmail("user12345@dominio.tech"));
        Assertions.assertDoesNotThrow(() -> user.setEmail("a_b_c@dom.co.uk"));
        Assertions.assertDoesNotThrow(() -> user.setEmail("contato@negocios.xyz"));
        Assertions.assertDoesNotThrow(() -> user.setEmail("p.d@c.com"));
        Assertions.assertDoesNotThrow(() -> user.setEmail("email.teste.1.2.3@site.com"));
        Assertions.assertDoesNotThrow(() -> user.setEmail("suporte_financeiro@finance.org"));
        Assertions.assertDoesNotThrow(() -> user.setEmail("email-valido@outro-dominio.com"));
        Assertions.assertDoesNotThrow(() -> user.setEmail("email.com.br@email.net"));
        Assertions.assertDoesNotThrow(() -> user.setEmail("usuario.com-hifen@dominio.com"));
        Assertions.assertDoesNotThrow(() -> user.setEmail("teste+123@email.com"));
        Assertions.assertDoesNotThrow(() -> user.setEmail("info@website.com"));
    }

}
