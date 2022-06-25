Algoritmo "semnome"

//menu
procedimento menu
var
   op:inteiro
inicio
   escreval("MENU:")
   escreval("1 - Usuário cadastrado")
   escreval("2 - Cadastrar usuário")
   escreval("0 - Sair")

   leia(op)
   se (op=1) entao
      login
   fimse
   se (op=2) entao
      cadastroCliente
   fimse
   se (op=0) entao
      fimalgoritmo
   senao
        escreval("Opção inválida! Tente novamente!")
   fimse
   escreval("")
   menu
fimprocedimento
//fim_menu

//cadastro
procedimento cadastroCliente
var
   n:inteiro
inicio
   n<-clientes
   escreval("CADASTRO NOVO USUÁRIO:")
   escreval("Digite seu nome completo:")
   leia(dados[0,n])
   escreval("Digite sua data de nascimento(dia/mês/ano):")
   leia(dados[1,n])
   escreval("Digite seu CPF(xxx.xxx.xxx-xx):")
   leia(dados[2,n])
   escreval("Qual gênero se indentifica(F/M/Outro):")
   leia(dados[3,n])
   escreval("Digite seu telefone((DDD) xxxxx-xxxx):")
   leia(dados[4,n])
   escreval("Digite seu endereço:")
   leia(dados[5,n])
   escreval("Digite sua senha:")
   leia(dados[6,n])
   clientes<-n+1
   escreval("Cadastro realizado com sucesso!")
   escreval ("")
   menu
fimprocedimento
//fimcadastro

//login
procedimento login
var
   cpf:caracter
   senha:caracter
   i:inteiro
   n:inteiro
   op:inteiro
inicio
   escreval("LOGIN:")
   escreval("Digite seu CPF(xxx.xxx.xxx-xx):")
   leia(cpf)
   escreval("Digite sua senha:")
   leia(senha)
   para i de 0 ate 10 faca
      se (cpf=dados[2,n]) e (senha=dados[6,n]) entao
         escreval("Login efetuado com sucesso!")
         clientea<-n
         menuUsuario
      senao
         n<-n+1
      fimse
   fimpara
   escreval("CPF ou senha incorreta!")
   escreval("Tente novamente ou retorne ao menu anterior")
   escreval("1 - Fazer login")
   escreval("2 - Voltar menu")
   leia(op)
   se (op=1) entao
      login
   senao
      menu
   fimse
   escreval ("")
fimprocedimento
//fim_login

//menu_usuario
procedimento menuUsuario
var
   op:inteiro
   n:inteiro
inicio
   n<-clientea
   escreval("Olá, ",dados[0,n],"!")
   escreval("Escolha:")
   escreval("1 - Acessar suas viagens")
   escreval("2 - Cadastrar viagem")
   escreval("3 - Alterar dados do cadastro")
   escreval("4 - Visualizar suas informações e suas viagens")
   escreval("5 - Desconectar")
   leia(op)
   se (op=1) entao
      viagens
   fimse
   se (op=2) entao
      cadastroViagem
   fimse
   se (op=3) entao
      altDados
   fimse
   se (op=4) entao
      visDados
   fimse
   se (op=5) entao
      menu
   senao
      escreval("Opção inválida! Tente novamente!")
      escreval("")
      menuUsuario
   fimse
fimprocedimento
//fim_menu_usuario

//cadastro viagens
procedimento cadastroViagem
var
   i:inteiro
   n:inteiro
   voltar:caracter
inicio
      n<-clientea
      dados[7,n]<-viagem[vetor]
   escreval("CADASTRO NOVA VIAGEM:")
   escreval("De onde você irá partir?")
   leia(viagem[0,i])
   escreval("Qual seu destino?")
   leia(dados[1,i])
   escreval("Que dia você irá?")
   leia(dados[2,i])
   escreval("Horário(00:00):")
   leia(dados[3,i])
   escreval("Viagem de volta?")
   leia (volta)
        se (voltar="S","Sim","sim","s") entao
           escreval("Que dia irá voltar?")
           leia (viagem[4,i])
           escreval("Horário(00:00):")
           leia (viaegm[5,i])
        fimse
   escreval("Cadastro realizado com sucesso!")
   escreval ("")
   menuUsuario
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
   viagem: vetor[0..3,0..10] de caracter
   clientes:inteiro
   clientea:inteiro

Inicio
   escreval("Olá! Nós da RecodeViagens estamos felizes por você estar aqui!")
   escreval("")
   menu
   escreval("Volte sempre!")



Fimalgoritmo