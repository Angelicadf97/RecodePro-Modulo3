Algoritmo "semnome"

//menu
procedimento menu
var
   op:inteiro
inicio
   escreval("MENU:")
   escreval("1 - Usuário cadastrado")
   escreval("2 - Cadastrar usuário")
   leia(op)
   se (op=1) entao
      login
   fimse
   se (op=2) entao
      cadastroCliente
   senao
      escreval("Opção inválida! Tente novamente!")
      escreval("")
      menu
   fimse
fimprocedimento

//cadastro
procedimento cadastroCliente
var
   n:inteiro
inicio
   escreval("CADASTRO NOVO USUÁRIO:")
   escreval("Digite seu nome completo:")
   leia(dados[0,n])
   escreval("Digite sua data de nascimento(dia/mês/ano):")
   leia(dados[1,n])
   escreval("Digite seu CPF(xxx.xxx.xxx-xx):")
   leia(dados[2,n])
   escreval("Qual gênero se indentifica(F/M):")
   leia(dados[3,n])
   escreval("Digite seu telefone((DDD) xxxxx-xxxx):")
   leia(dados[4,n])
   escreval("Digite seu endereço:")
   leia(dados[5,n])
   escreval("Digite sua senha:")
   leia(dados[6,n])
   n<-n+1
   escreval("Cadastro realizado com sucesso!")
   escreval ("")
   menu
fimprocedimento

//login
procedimento login
var
   cpf:caracter
   senha:caracter
   i:inteiro
   n:inteiro
inicio
   escreval("LOGIN:")
   escreval("Digite seu CPF(xxx.xxx.xxx-xx):")
   leia(cpf)
   escreval("Digite sua senha:")
   leia(senha)
   //para i de 0 ate 100 faca
      //se (cpf=dados[2,n]) e (senha=dados[6,n]) entao
         //escreval("Login efetuado com sucesso!")
         //n<-n+1
      //fimse
   //fimpara
   escreval ("")
   menuUsuario
fimprocedimento

//verificao_login
funcao verificao:inteiro
var
   para i de 0 ate 100 faca
      se (cpf=dados[2,n]) e (senha=dados[6,n]) entao
         escreval("Login efetuado com sucesso!")
         n<-n+1
      fimse
   fimpara
   retorne
fimfuncao

//menu_usuario
procedimento menuUsuario
var
   op:inteiro
   n:inteiro
inicio

   escreval("Olá, ",dados[0,n],"!")
   escreval("Escolha:")
   escreval("1 - Acessar suas viagens")
   escreval("2 - Cadastrar viagem")
   escreval("3 - Alterar dados do cadastro")
   escreval("4 - Visualizar suas informações e suas viagens")
   escreval("5 - Desconectar")
   leia(op)
fimprocedimento

//cadastro viagens
procedimento cadastroViagem
var
inicio

fimprocedimento

//Viagens
procedimento viagens
var
inicio

fimprocedimento

//alterar_dados
procedimento altDados
var
inicio

fimprocedimento

//visualizar_dados
procedimento visDados
var
inicio

fimprocedimento


Var
   dados: vetor[0..7,0..10] de caracter
   viagens: vetor[0..3,0..10] de caracter

Inicio
   dados[7,0]<-viagens[i,0]
   escreval("Olá! Nós da RecodeViagens estamos felizes por você estar aqui!")
   escreval("")
   menu
   escreval("Volte sempre!")



Fimalgoritmo