Algoritmo "Agencia"

//----------menu----------
procedimento menu
var
   op:inteiro
inicio
   escreval("...................................................")
   escreval("MENU:")
   escreval("1 - Buscar cliente")
   escreval("2 - Cadastrar cliente")
   escreval("0 - Sair")
   repita
      escreva("Digite uma opção:")
      leia(op)
      escolha (op)
      caso 1
         buscarcliente
      caso 2
         cadastrarcliente
      caso 0
           fimalgoritmo
      outrocaso
               escreval("Opção inválida! Tente novamente!")
               escreval("")
               fimescolha
   ate (op>0) e (op<3)
fimprocedimento
//----------fim_menu----------

//----------busca_cliente----------
procedimento buscarcliente
var
   cpf:caracter
   n:inteiro
   op:inteiro
inicio
   cpfa<-dadoscliente[2,n]
   escreval("")
   escreval(".......")
   escreval("BUSCAR CLIENTES CADASTRADOS:")
   escreval("Digite o CPF(xxx.xxx.xxx-xx)do cliente:")
   leia(cpf)
   para n de 0 ate 10 faca
      se (cpf=dadoscliente[2,n]) entao
         escreval("Cliente cadastrado!")
         cpfa<-dadoscliente[2,n]
         dadoscliente
      senao
         n<-n+1
      fimse
   fimpara
   escreval("Cliente não cadastrado ou CPF inválido!")
   escreval("Tente novamente ou retorne ao menu anterior")
   escreval("1 - Tentar novamente")
   escreval("2 - Voltar ao menu anterior")
   repita
      escreva("Digite uma opção:")
      leia(op)
      escolha (op)
      caso 1
         buscarcliente
      caso 2
         menu
      outrocaso
         escreval("Opção inválida! Tente novamente!")
         escreval("")
      fimescolha
   ate (op>0) e (op<3)
fimprocedimento
//----------fim_busca_cliente----------

//----------fim_cadastro_cliente----------
procedimento cadastrarcliente
var
   n:inteiro
   op:inteiro
inicio
   n<-cliente
   escreval("")
   escreval(".......")
   escreval("CADASTRO CLIENTE:")
   escreval("Digite o nome completo:")
   leia(dadoscliente[0,n])
   escreval("Digite a data de nascimento(dia/mês/ano):")
   leia(dadoscliente[1,n])
   escreval("Digite o CPF(xxx.xxx.xxx-xx):")
   leia(dadoscliente[2,n])
   escreval("Digite o gênero(F/M/Outro):")
   leia(dadoscliente[3,n])
   escreval("Digite o telefone((DDD) xxxxx-xxxx):")
   leia(dadoscliente[4,n])
   escreval("Digite o endereço:")
   leia(dadoscliente[5,n])
   escreval("Digite o email:")
   leia(dadoscliente[6,n])
   cliente<-n+1
   cpfa<-dadoscliente[2,n]
   escreval("Cadastro realizado com sucesso!")
   escreval ("")
   escreval("1 - Acessar dados do cliente")
   escreval("2 - Cadastrar novo cliente")
   escreval("0 - Voltar ao menu anterior")
   repita
      escreva("Digite uma opção:")
      leia(op)
      escreval("")
      escolha (op)
      caso 1
         dadoscliente
      caso 2
         cadastrarcliente
      caso 0
         menu
      outrocaso
         escreval("Opção inválida! Tente novamente!")
         escreval("")
      fimescolha
   ate (op>=0) e (op<3)
   menu
fimprocedimento
//----------fim_cadastro_cliente----------

//----------fim_dados_cliente----------
procedimento dadoscliente
var
   n:inteiro
   i:inteiro
   v:inteiro
   op:inteiro
   j:inteiro
inicio
   para i de 0 ate 10 faca
      se (cpfa=dadoscliente[2,i]) entao
         n<-i
      senao
         i<-i+1
      fimse
   fimpara
   escreval("")
   escreval(".......")
   escreval("DADOS CLIENTE:")
   escreval("Nome:",dadoscliente[0,n])
   escreval("Data de nascimento:",dadoscliente[1,n])
   escreval("CPF:",dadoscliente[2,n])
   escreval("Gênero:",dadoscliente[3,n])
   escreval("Telefone:",dadoscliente[4,n])
   escreval("Endereço:",dadoscliente[5,n])
   escreval("Email:",dadoscliente[6,n])
   escreval("")
   escreval("VIAGENS CADASTRADAS:")
      para j de 0 ate 10 faca
         se (cpfa=dadosviagem[0,j]) entao
            v<-j
         senao
            j<-j+1
         fimse
      fimpara
      escreval("Código da viagem:",dadosviagem[1,v])
      escreval("Destino:",dadosviagem[2,v],"-",dadosviagem[3,v])
      escreval("Partida:",dadosviagem[4,v],"-",dadosviagem[5,v])
      escreval("Data:",dadosviagem[6,v],"            Horário:",dadosviagem[7,v])
      se (dadosviagem[8,v]="S") entao
         escreval("Data da volta:",dadosviagem[9,v],"   Horário:",dadosviagem[10,v])
      fimse
      j<-v+1
   escreval("")
   escreval("1 - Cadastrar viagem")
   escreval("0 - Voltar ao menu inicial")
   repita
      escreva("Digite uma opção:")
      leia(op)
      escreval("")
      escolha (op)
      caso 1
         cadastrarviagem
      caso 0
         menu
      outrocaso
         escreval("Opção inválida! Tente novamente!")
         escreval("")
      fimescolha
   ate (op>=0) e (op<2)

fimprocedimento
//----------fim_dados_cliente----------

//----------fim_cadastro_viagem----------
procedimento cadastrarviagem
var
   v:inteiro
   i:inteiro
   j:inteiro
   op:inteiro
   cidade:caracter
   contador:inteiro
inicio
   v<-viagem+1
   para i de 0 ate 10 faca
      se (cpfa=dadoscliente[2,i]) entao
         dadosviagem[0,v]<-cpfa
      senao
         i<-i+1
      fimse
   fimpara
   contador<-codigo
   escreval("")
   escreval(".......")
   escreval("CADASTRO VIAGEM:")
   escreval("Destino:")
   leia(dadosviagem[2,v])
   escreval("UF Destino:")
   leia(dadosviagem[3,v])
   escreval("Partida:")
   leia(dadosviagem[4,v])
   escreval("UF Partida:")
   leia(dadosviagem[5,v])
   escreval("Data(00/00/0000):")
   leia(dadosviagem[6,v])
   escreval("Horário(00:00):")
   leia(dadosviagem[7,v])
   escreval("Viagem de volta?(S/N)")
   leia(dadosviagem[8,v])
   se (dadosviagem[8,v]="S") entao
      escreval("Data da volta(00/00/0000):")
      leia(dadosviagem[9,v])
      escreval("Horário da volta(00:00):")
      leia(dadosviagem[10,v])
   senao
      dadosviagem[9,v]<-"--"
      dadosviagem[10,v]<-"--"
   fimse
   dadosviagem[1,v]<-contador
   codigo<-contador+1
   viagem<-v
   escreval("Cadastro realizado com sucesso!")
   escreval ("")
   escreval("1 - Acessar dados do cliente")
   escreval("2 - Cadastrar nova viagem")
   escreval("0 - Voltar ao menu principal")
   repita
      escreva("Digite uma opção:")
      leia(op)
      escreval("")
      escolha (op)
      caso 1
         dadoscliente
      caso 2
         cadastrarviagem
      caso 0
         menu
      outrocaso
         escreval("Opção inválida! Tente novamente!")
         escreval("")
      fimescolha
   ate (op>=0) e (op<3)
   menu
fimprocedimento
//----------fim_cadastro_viagem----------

Var
   dadoscliente: vetor[0..7,0..10] de caracter
   dadosviagem: vetor[0..10,0..10] de caracter
   cliente:inteiro
   viagem:inteiro
   cpfa:caracter
   codigo:inteiro

Inicio
   escreval("Olá! Nós da RecodeViagens estamos felizes por você estar aqui!")
   escreval("")
   menu
   escreval("Volte sempre!")



Fimalgoritmo