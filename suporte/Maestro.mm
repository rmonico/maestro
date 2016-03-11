<map version="1.0.1">
<!-- To view this file, download free mind mapping software FreeMind from http://freemind.sourceforge.net -->
<node CREATED="1413173006422" ID="ID_1709137031" MODIFIED="1413174745754" TEXT="Maestro">
<node CREATED="1413174747586" ID="ID_211431028" MODIFIED="1437367015253" POSITION="right" TEXT="Modelo">
<node CREATED="1413175726390" ID="ID_58940402" MODIFIED="1413176825800" TEXT="Object">
<richcontent TYPE="NOTE"><html>
  <head>
    
  </head>
  <body>
    <p>
      Super objeto pai de todos
    </p>
  </body>
</html></richcontent>
<node CREATED="1413175793859" ID="ID_1361721903" MODIFIED="1413175795075" TEXT="id"/>
<node CREATED="1413175795400" ID="ID_697473912" MODIFIED="1413175809370" TEXT="creator"/>
<node CREATED="1413175809574" ID="ID_1299957690" MODIFIED="1413175813528" TEXT="created_on"/>
<node CREATED="1413175829750" ID="ID_201613428" MODIFIED="1413226557167" TEXT="last_modifier">
<richcontent TYPE="NOTE"><html>
  <head>
    
  </head>
  <body>
    <p>
      &#xda;ltima pessoa que modificou
    </p>
  </body>
</html></richcontent>
</node>
<node CREATED="1413175813747" ID="ID_1128051741" MODIFIED="1413175828784" TEXT="last_modified"/>
</node>
<node CREATED="1413173487411" ID="ID_662037815" MODIFIED="1413173490149" TEXT="UserObject">
<node CREATED="1413173011252" ID="ID_1301854629" MODIFIED="1413174773171" TEXT="Tag">
<node CREATED="1413174719524" ID="ID_63449019" MODIFIED="1413174724843" TEXT="supertag -&gt; Tag"/>
<node CREATED="1413173164178" ID="ID_721494309" MODIFIED="1413173165079" TEXT="name"/>
</node>
<node CREATED="1413173013006" ID="ID_798017292" MODIFIED="1413174772822" TEXT="Task">
<node CREATED="1413173185616" ID="ID_1773226866" MODIFIED="1413173193082" TEXT="supertask -&gt; Task"/>
<node CREATED="1413173188133" ID="ID_957351604" MODIFIED="1413173189164" TEXT="name"/>
</node>
</node>
<node CREATED="1413173015106" ID="ID_151757705" MODIFIED="1413173499753" TEXT="TaskTag">
<node CREATED="1413173207881" ID="ID_804901998" MODIFIED="1413173218325" TEXT="task -&gt; Task"/>
<node CREATED="1413173218600" ID="ID_732721005" MODIFIED="1413173221206" TEXT="tag -&gt; Tag"/>
</node>
<node CREATED="1413173238058" ID="ID_1463042925" MODIFIED="1413173500059" TEXT="TagAttribute">
<node CREATED="1413173244627" ID="ID_109019288" MODIFIED="1413173247355" TEXT="tag -&gt; Tag"/>
<node CREATED="1413173250610" ID="ID_23388412" MODIFIED="1413173251377" TEXT="name"/>
<node CREATED="1413173261086" ID="ID_425811219" MODIFIED="1413173284197" TEXT="valueType -&gt; TagAttributeValueType"/>
</node>
<node CREATED="1413173285226" ID="ID_306946758" MODIFIED="1426128441132" TEXT="TagAttributeValueType (enum)">
<node CREATED="1413174130806" ID="ID_419633634" MODIFIED="1426128281290" TEXT="REMINDER">
<richcontent TYPE="NOTE"><html>
  <head>
    
  </head>
  <body>
    <p>
      Todas as tags com os atributos listados nos sub-n&#243;s devem tamb&#233;m possuir este atributo.
    </p>
  </body>
</html></richcontent>
<node CREATED="1413173332896" ID="ID_1349417614" MODIFIED="1413175396759" TEXT="GPS">
<richcontent TYPE="NOTE"><html>
  <head>
    
  </head>
  <body>
    <p>
      Aplic&#xe1;vel a Tarefas apenas. Recebe um lat/lon e dist&#xe2;ncia. Aciona um lembrete quando o dispositivo estiver a dist&#xe2;ncia informada do lat/lon informado
    </p>
  </body>
</html></richcontent>
</node>
<node CREATED="1413173324054" ID="ID_701090438" MODIFIED="1413175407801" TEXT="CALENDAR">
<richcontent TYPE="NOTE"><html>
  <head>
    
  </head>
  <body>
    <p>
      Aplic&#xe1;vel a Tarefas apenas. Receba uma data/hora, aviso_previo e sinc_google=yes/no. Faz a tarefa aparecer no view de calend&#xe1;rio e aciona um lembrete quando a hora do dispositivo chegar a data/hora - aviso_previo. Sincroniza a tarefa com o calend&#xe1;rio do google conforme valor informado.
    </p>
  </body>
</html></richcontent>
<node CREATED="1413225731901" ID="ID_1064953457" MODIFIED="1413225777187" TEXT="TODAY">
<richcontent TYPE="NOTE"><html>
  <head>
    
  </head>
  <body>
    <p>
      Aplicavel a Tags apenas. N&#xe3;o recebe nada. Devolve uma lista de tarefas do dia.
    </p>
  </body>
</html></richcontent>
</node>
<node CREATED="1413225779077" ID="ID_162050493" MODIFIED="1413225804554" TEXT="TOMORROW">
<richcontent TYPE="NOTE"><html>
  <head>
    
  </head>
  <body>
    <p>
      Aplicavel a Tags apenas. N&#xe3;o recebe nada. Devolve uma lista de tarefas do dia seguinte.
    </p>
  </body>
</html></richcontent>
</node>
<node CREATED="1413225805325" ID="ID_1942221476" MODIFIED="1413225817196" TEXT="LATE">
<richcontent TYPE="NOTE"><html>
  <head>
    
  </head>
  <body>
    <p>
      Aplicavel a Tags apenas. N&#xe3;o recebe nada. Devolve uma lista de tarefas atrasadas
    </p>
  </body>
</html></richcontent>
</node>
</node>
<node CREATED="1413174223060" ID="ID_21330408" MODIFIED="1413175416241" TEXT="PLACE">
<richcontent TYPE="NOTE"><html>
  <head>
    
  </head>
  <body>
    <p>
      Aplic&#xe1;vel a Tarefas apenas. Recebe um "lugar" gen&#xe9;rico (por exemplo farm&#xe1;cia, mercado, padaria, etc). Aciona um lembrete quando o dispositivo estiver pr&#xf3;ximo a um estabelecimento do tipo informado.
    </p>
  </body>
</html></richcontent>
</node>
<node CREATED="1413174294136" ID="ID_987601370" MODIFIED="1413175420864" TEXT="PERSON?">
<richcontent TYPE="NOTE"><html>
  <head>
    
  </head>
  <body>
    <p>
      Aplic&#xe1;vel a Tarefas apenas. Recebe um contato. Aciona um lembrete quando o dispositivo estiver pr&#xf3;ximo a pessoa (como?)
    </p>
  </body>
</html></richcontent>
</node>
</node>
<node CREATED="1426128216354" ID="ID_1689693902" MODIFIED="1426128229909" TEXT="Aplicavel a Tag">
<node CREATED="1413174372586" ID="ID_701489731" MODIFIED="1413175328719" TEXT="DRAWER">
<richcontent TYPE="NOTE"><html>
  <head>
    
  </head>
  <body>
    <p>
      Aplic&#xe1;vel a Tags apenas. N&#xe3;o recebe nada. Faz a tag aparecer na gaveta.
    </p>
  </body>
</html></richcontent>
</node>
<node CREATED="1413174438521" ID="ID_550652939" MODIFIED="1413175337379" TEXT="ALL_THESE_WORDS">
<richcontent TYPE="NOTE"><html>
  <head>
    
  </head>
  <body>
    <p>
      Aplic&#xe1;vel a Tags apenas. Recebe uma lista de palavras separadas por espa&#xe7;o. Lista as tarefas que possuem todas as palavras informadas.
    </p>
  </body>
</html></richcontent>
</node>
<node CREATED="1413174511320" ID="ID_1450812710" MODIFIED="1413175342441" TEXT="SOME_OF_WORDS">
<richcontent TYPE="NOTE"><html>
  <head>
    
  </head>
  <body>
    <p>
      Aplic&#xe1;vel a Tags apenas. Recebe uma lista de palavras separadas por espa&#xe7;o. Lista as tarefas que possuem pelo menos uma das palavras informadas.
    </p>
  </body>
</html></richcontent>
</node>
<node CREATED="1413173769504" ID="ID_336645230" MODIFIED="1426128366838" TEXT="ALL_THESE_TAGS">
<richcontent TYPE="NOTE"><html>
  <head>
    
  </head>
  <body>
    <p>
      Aplic&#225;vel a Tags apenas. Recebe uma lista de tags, devolve as tarefas que tiverem todas as tags da lista
    </p>
  </body>
</html></richcontent>
</node>
<node CREATED="1413173773968" ID="ID_853140289" MODIFIED="1413175474598" TEXT="SOME_OF_TAGS">
<richcontent TYPE="NOTE"><html>
  <head>
    
  </head>
  <body>
    <p>
      Aplic&#xe1;vel a Tags apenas. Recebe uma lista de tags, devolve todas as tarefas que tiverem pelo menos uma das tags da lista
    </p>
  </body>
</html></richcontent>
</node>
<node CREATED="1413176647029" ID="ID_1428071589" MODIFIED="1426128398213" TEXT="ALL_TAGS">
<richcontent TYPE="NOTE"><html>
  <head>
    
  </head>
  <body>
    <p>
      Aplicavel a Tags apenas. N&#227;o recebe nada. Mostra todas as Tags existentes.
    </p>
  </body>
</html></richcontent>
</node>
<node CREATED="1413176650575" ID="ID_1836486583" MODIFIED="1413176735082" TEXT="ALL_TASKS">
<richcontent TYPE="NOTE"><html>
  <head>
    
  </head>
  <body>
    <p>
      Aplicavel a Tags apenas. N&#xe3;o recebe nada. Mostra todas as Tarefas existentes.
    </p>
  </body>
</html></richcontent>
</node>
<node CREATED="1413176656887" ID="ID_661977118" MODIFIED="1426128170791" TEXT="EVERYTHING">
<richcontent TYPE="NOTE"><html>
  <head>
    
  </head>
  <body>
    <p>
      Aplicavel a Tags apenas. N&#227;o recebe nada. Mostra todos os UserObject existentes.
    </p>
  </body>
</html></richcontent>
</node>
<node CREATED="1413176705333" ID="ID_1863504962" MODIFIED="1413225829070" TEXT="SYSTEM_TAG">
<richcontent TYPE="NOTE"><html>
  <head>
    
  </head>
  <body>
    <p>
      Aplicavel a Tags apenas. N&#xe3;o recebe nada. Quando marcado com este atributo a tag n&#xe3;o fica dispon&#xed;vel para o usu&#xe1;rio marcar tarefas com ela, e nem pode ser exclu&#xed;da, renomeada ou configurada pelo usu&#xe1;rio.
    </p>
  </body>
</html></richcontent>
</node>
<node CREATED="1426128872622" ID="ID_1405127908" MODIFIED="1426128887139" TEXT="BULLET_ADD">
<richcontent TYPE="NOTE"><html>
  <head>
    
  </head>
  <body>
    <p>
      Adicionavel pelo menu de bullet da tarefa
    </p>
  </body>
</html></richcontent>
</node>
</node>
<node CREATED="1426128386531" ID="ID_1483661008" MODIFIED="1426128392497" TEXT="Aplicavel a Tarefas">
<node CREATED="1413175213331" ID="ID_1806904022" MODIFIED="1426128377744" TEXT="PRIVATE">
<richcontent TYPE="NOTE"><html>
  <head>
    
  </head>
  <body>
    <p>
      Aplic&#225;vel a Tarefas apenas. N&#227;o recebe nada. Ao renderizar a tarefa na lista mostra trocar todos os caracteres do nome por x. Ao abrir a tarefa pede um pin do aplicativo.
    </p>
  </body>
</html></richcontent>
</node>
<node CREATED="1413175559111" ID="ID_932721768" MODIFIED="1413175631809" TEXT="DONE">
<richcontent TYPE="NOTE"><html>
  <head>
    
  </head>
  <body>
    <p>
      Aplic&#xe1;vel a Tarefa apenas. N&#xe3;o recebe nada. Deve mudar a formata&#xe7;&#xe3;o da tarefa na lista.
    </p>
  </body>
</html></richcontent>
</node>
</node>
<node CREATED="1426128250280" ID="ID_1727049166" MODIFIED="1426128261004" TEXT="Aplicavel a ambos (tag e tarefa)">
<node CREATED="1413173318854" ID="ID_149301598" MODIFIED="1426128241780" TEXT="NOTE">
<richcontent TYPE="NOTE"><html>
  <head>
    
  </head>
  <body>
    <p>
      Aplic&#225;vel a Tags e Tarefas. Recebe um texto. Adiciona uma nota a tarefa que aparece na lista.
    </p>
  </body>
</html></richcontent>
</node>
<node CREATED="1413174878758" ID="ID_1597902582" MODIFIED="1413175373247" TEXT="ATTACHED">
<richcontent TYPE="NOTE"><html>
  <head>
    
  </head>
  <body>
    <p>
      Aplic&#xe1;vel a Tags e Tarefas. Recebe uma URL. Mostra um link para a URL na lista quando a tarefa &#xe9; renderizada.
    </p>
  </body>
</html></richcontent>
</node>
<node CREATED="1413173327765" ID="ID_1222100775" MODIFIED="1413175384324" TEXT="PRIORITY">
<richcontent TYPE="NOTE"><html>
  <head>
    
  </head>
  <body>
    <p>
      Aplic&#xe1;vel a Tags e Tarefas. Recebe um inteiro que indica a prioridade da tarefa. Quanto menor mais priorit&#xe1;ria a tarefa &#xe9;.
    </p>
  </body>
</html></richcontent>
</node>
<node CREATED="1413173343451" ID="ID_1090433808" MODIFIED="1413175444141" TEXT="ALIVE">
<richcontent TYPE="NOTE"><html>
  <head>
    
  </head>
  <body>
    <p>
      Aplic&#xe1;vel a Tags e Tarefas. Indica uma tag viva. O valor da tag ser&#xe1; um script de marcar/remover tags de tarefa mediante condi&#xe7;&#xf5;es (constantes no script tamb&#xe9;m)
    </p>
  </body>
</html></richcontent>
</node>
<node CREATED="1413173729380" ID="ID_1703781454" MODIFIED="1413175451163" TEXT="FORMAT">
<richcontent TYPE="NOTE"><html>
  <head>
    
  </head>
  <body>
    <p>
      Aplic&#xe1;vel a Tags e Tarefas. Cor de fundo, cor da letra, formata&#xe7;&#xe3;o, etc
    </p>
  </body>
</html></richcontent>
</node>
</node>
</node>
<node CREATED="1413173386855" ID="ID_314924194" MODIFIED="1413173502104" TEXT="TagProperty">
<node CREATED="1413173401538" ID="ID_1748073251" MODIFIED="1413173430913" TEXT="taskTag -&gt; TaskTag"/>
<node CREATED="1413173408570" ID="ID_997998676" MODIFIED="1413173425874" TEXT="attribute -&gt; TagAttribute"/>
<node CREATED="1413173476599" ID="ID_626605992" MODIFIED="1413173477477" TEXT="value"/>
</node>
</node>
<node CREATED="1413174754407" FOLDED="true" ID="ID_979565566" MODIFIED="1426128075489" POSITION="right" TEXT="Funcionalidades (categoria)">
<node CREATED="1413176603604" ID="ID_1609654143" MODIFIED="1413176606788" TEXT="Navega&#xe7;&#xe3;o">
<node CREATED="1413174782902" ID="ID_1265740557" MODIFIED="1413225395270" TEXT="Gaveta">
<richcontent TYPE="NOTE"><html>
  <head>
    
  </head>
  <body>
    <p>
      Mostrar as tags que possuam um TagAttributeValueType de Drawer
    </p>
  </body>
</html></richcontent>
</node>
<node CREATED="1413174779079" ID="ID_1430001074" MODIFIED="1413225395278" TEXT="Lista">
<richcontent TYPE="NOTE"><html>
  <head>
    
  </head>
  <body>
    <p>
      Inicialmente mostra as tarefas da tag selecionada na gaveta.
    </p>
  </body>
</html></richcontent>
</node>
<node CREATED="1413177034193" ID="ID_47252173" MODIFIED="1413177037768" TEXT="Calend&#xe1;rio"/>
</node>
<node CREATED="1413174797549" ID="ID_62375673" MODIFIED="1413225389765" TEXT="Barra r&#xe1;pida de tarefa">
<richcontent TYPE="NOTE"><html>
  <head>
    
  </head>
  <body>
    <p>
      Dever&#xe1; adicionar/procurar uma tarefa rapidamente
    </p>
  </body>
</html></richcontent>
</node>
<node CREATED="1413176617273" ID="ID_1426892700" MODIFIED="1413176623785" TEXT="Itens de lista">
<node CREATED="1413177168098" ID="ID_1906973330" MODIFIED="1413226608199" TEXT="Ambos">
<richcontent TYPE="NOTE"><html>
  <head>
    
  </head>
  <body>
    <p>
      Devem possuir o nome do objeto e um bot&#xe3;o de bullet &#xe0; direita.
    </p>
  </body>
</html></richcontent>
</node>
<node CREATED="1413175512579" ID="ID_985477837" MODIFIED="1413225411773" TEXT="Item de lista de Tag">
<richcontent TYPE="NOTE"><html>
  <head>
    
  </head>
  <body>
    <p>
      Deve ter um &#xed;cone para indicar que n&#xe3;o &#xe9; uma tarefa.
    </p>
  </body>
</html></richcontent>
</node>
<node CREATED="1413175544128" ID="ID_1315423697" MODIFIED="1413226608098" TEXT="Item de lista de Tarefa">
<richcontent TYPE="NOTE"><html>
  <head>
    
  </head>
  <body>
    <p>
      Deve ter um &#xed;cone &#xe0; esquerda indicando seu status (aberto [default], atrasado e conclu&#xed;do)
    </p>
  </body>
</html></richcontent>
</node>
</node>
<node CREATED="1413176859268" ID="ID_921576524" MODIFIED="1413176866230" TEXT="Gerenciamento de Tag">
<node CREATED="1413176586495" ID="ID_1285275892" MODIFIED="1413225472010" TEXT="Renomear Tag">
<richcontent TYPE="NOTE"><html>
  <head>
    
  </head>
  <body>
    <p>
      Dispon&#xed;vel na item da lista.
    </p>
  </body>
</html></richcontent>
</node>
<node CREATED="1413176596611" ID="ID_1972703725" MODIFIED="1413177164725" TEXT="Configurar tag">
<richcontent TYPE="NOTE"><html>
  <head>
    
  </head>
  <body>
    <p>
      Dispon&#xed;vel no bot&#xe3;o de bullet do item da lista. Consiste em configurar os atributos da tag e seus valores.
    </p>
  </body>
</html></richcontent>
</node>
<node CREATED="1413176628490" ID="ID_280210944" MODIFIED="1413177348847" TEXT="Excluir Tag">
<richcontent TYPE="NOTE"><html>
  <head>
    
  </head>
  <body>
    <p>
      Dispon&#xed;vel no item da lista.
    </p>
  </body>
</html></richcontent>
</node>
</node>
<node CREATED="1413176941101" ID="ID_1535905969" MODIFIED="1413176959485" TEXT="Gerenciamento de Tarefa">
<node CREATED="1413177429291" ID="ID_1986887358" MODIFIED="1413226663536" TEXT="Excluir tarefa">
<richcontent TYPE="NOTE"><html>
  <head>
    
  </head>
  <body>
    <p>
      Dispon&#xed;vel no bot&#xe3;o de bullet do item de tarefa.
    </p>
  </body>
</html></richcontent>
</node>
<node CREATED="1413177432367" ID="ID_950152206" MODIFIED="1413226792676" TEXT="Renomear tarefa">
<richcontent TYPE="NOTE"><html>
  <head>
    
  </head>
  <body>
    <p>
      Dispon&#xed;vel no bot&#xe3;o de bullet do item de tarefa.
    </p>
  </body>
</html></richcontent>
</node>
<node CREATED="1413176960270" ID="ID_1656664346" MODIFIED="1413226792682" TEXT="Atribuir tags">
<richcontent TYPE="NOTE"><html>
  <head>
    
  </head>
  <body>
    <p>
      Dispon&#xed;vel no bot&#xe3;o de bullet do item de tarefa.
    </p>
  </body>
</html></richcontent>
</node>
</node>
</node>
<node CREATED="1413226018811" ID="ID_431332729" MODIFIED="1426127922400" POSITION="right" TEXT="MainActivity">
<richcontent TYPE="NOTE"><html>
  <head>
    
  </head>
  <body>
    <p>
      Funcionalidades por layout
    </p>
  </body>
</html></richcontent>
<node CREATED="1413225596110" ID="ID_1934671788" MODIFIED="1426128478456" TEXT="Bot&#xe3;o da barra de t&#xed;tulo">
<node CREATED="1413176870892" ID="ID_1670012444" MODIFIED="1413225504516" TEXT="Adicionar tag">
<richcontent TYPE="NOTE"><html>
  <head>
    
  </head>
  <body>
    <p>
      Dispon&#xed;vel no bot&#xe3;o de menu quando a gaveta estiver aberta. Est&#xe1; fun&#xe7;&#xe3;o s&#xf3; dever&#xe1; existir para criar tags da gaveta.
    </p>
  </body>
</html></richcontent>
</node>
<node CREATED="1413226214801" ID="ID_1105001107" MODIFIED="1426127094940" TEXT="Reordenar">
<richcontent TYPE="NOTE"><html>
  <head>
    
  </head>
  <body>
    <p>
      Disponivel com a gaveta fechada. Ver se e valido ter esta opcao com a gaveta aberta.
    </p>
  </body>
</html></richcontent>
</node>
<node CREATED="1413227352897" ID="ID_315810424" MODIFIED="1426127103099" TEXT="Configura&#xe7;&#xf5;es (do app) #todo">
<richcontent TYPE="NOTE"><html>
  <head>
    
  </head>
  <body>
    <p>
      Apenas com a gaveta fechada
    </p>
  </body>
</html></richcontent>
</node>
<node CREATED="1413226382304" ID="ID_127904162" MODIFIED="1426128538564" TEXT="Busca avan&#xe7;ada #todo">
<richcontent TYPE="NOTE"><html>
  <head>
    
  </head>
  <body>
    <p>
      Apenas com a gaveta fechada. Definir por quais informacoes permitira a busca.
    </p>
  </body>
</html></richcontent>
</node>
</node>
<node CREATED="1413226031547" ID="ID_1798227431" MODIFIED="1413226113415" TEXT="Label da barra de t&#xed;tulo">
<richcontent TYPE="NOTE"><html>
  <head>
    
  </head>
  <body>
    <p>
      Deve ser maestro quando a gaveta estiver aberta. Quando estiver fechada deve ser o t&#xed;tulo da tag + super tags da tag selecionada seguido pelas super tarefas da tarefa selecionada em um linha abaixo com letra de detalhe.
    </p>
  </body>
</html></richcontent>
</node>
<node CREATED="1413174782902" ID="ID_838769800" MODIFIED="1426128961980" TEXT="Gaveta">
<richcontent TYPE="NOTE"><html>
  <head>
    
  </head>
  <body>
    <p>
      Mostrar as tags que possuam um TagAttributeValueType de Drawer
    </p>
  </body>
</html></richcontent>
<node CREATED="1413225419440" ID="ID_1304240441" MODIFIED="1426127005252" TEXT="Itens iguais aos da lista principal">
<richcontent TYPE="NOTE"><html>
  <head>
    
  </head>
  <body>
    <p>
      11/mar: rever se estes itens devem ficar iguais aos da lista principal mesmo..... acho que pode ser usado de maneira mais funcional
    </p>
  </body>
</html></richcontent>
</node>
<node CREATED="1413225663318" FOLDED="true" ID="ID_103523540" MODIFIED="1426128973104" TEXT="Bot&#xf5;es inferiores">
<font NAME="SansSerif" SIZE="12"/>
<node CREATED="1413225679053" FOLDED="true" ID="ID_452260561" MODIFIED="1426128971401" TEXT="Calend&#xe1;rio #todo">
<richcontent TYPE="NOTE"><html>
  <head>
    
  </head>
  <body>
    <p>
      A vis&#xe3;o por dia ficar&#xe1; na lista de tarefas mesmo, ser&#xe1; um tag para isso. Elaborar direito o que vai ter nessa atividade.
    </p>
  </body>
</html></richcontent>
<node CREATED="1413225688846" ID="ID_1964144863" MODIFIED="1413225949650" TEXT="Vis&#xe3;o por semana"/>
<node CREATED="1413225949963" ID="ID_1161440616" MODIFIED="1413225953114" TEXT="Vis&#xe3;o por m&#xea;s"/>
</node>
<node CREATED="1413225674822" ID="ID_1852026323" MODIFIED="1413225678482" TEXT="Sair"/>
</node>
</node>
<node CREATED="1413174779079" ID="ID_1016328759" MODIFIED="1426127922423" TEXT="Lista principal #todo">
<richcontent TYPE="NOTE"><html>
  <head>
    
  </head>
  <body>
    <p>
      Inicialmente mostra as tarefas da tag selecionada na gaveta.
    </p>
  </body>
</html></richcontent>
<node CREATED="1413174797549" ID="ID_1887772205" MODIFIED="1413253367745" TEXT="Barra r&#xe1;pida de tarefa">
<richcontent TYPE="NOTE"><html>
  <head>
    
  </head>
  <body>
    <p>
      Dever&#xe1; adicionar/procurar uma tarefa rapidamente. Deve fazer uma busca incremental pelos itens da lista ativa. Quando a busca n&#xe3;o encontrar nada deve mudar o bot&#xe3;o de pesquisa para adicionar. Um toque duplo no bot&#xe3;o de busca aciona o fragmento de busca avan&#xe7;ada.
    </p>
  </body>
</html></richcontent>
<node CREATED="1413177417190" ID="ID_750262841" MODIFIED="1413226665124" TEXT="Adicionar tarefa">
<richcontent TYPE="NOTE"><html>
  <head>
    
  </head>
  <body>
    <p>
      Disponivel na barra rapida de tarefa
    </p>
  </body>
</html></richcontent>
</node>
<node CREATED="1413226682838" ID="ID_732501725" MODIFIED="1426128482918" TEXT="Busca simples">
<richcontent TYPE="NOTE"><html>
  <head>
    
  </head>
  <body>
    <p>
      Busca incremental pelo t&#237;tulo da tarefa
    </p>
  </body>
</html></richcontent>
</node>
</node>
<node CREATED="1413175512579" ID="ID_246943962" MODIFIED="1426127191836" TEXT="Item de Tag">
<richcontent TYPE="NOTE"><html>
  <head>
    
  </head>
  <body>
    <p>
      Deve ter um &#237;cone para indicar que n&#227;o &#233; uma tarefa.
    </p>
  </body>
</html></richcontent>
<node CREATED="1413225486447" ID="ID_1230291180" MODIFIED="1413226208710" TEXT="Label">
<richcontent TYPE="NOTE"><html>
  <head>
    
  </head>
  <body>
    <p>
      Quando o item for da gaveta, deve selecion&#xe1;-lo na lista
    </p>
  </body>
</html></richcontent>
</node>
<node CREATED="1413225488303" ID="ID_489957864" MODIFIED="1413225491868" TEXT="Bullet menu">
<node CREATED="1413176586495" ID="ID_12999075" MODIFIED="1413225472010" TEXT="Renomear Tag">
<richcontent TYPE="NOTE"><html>
  <head>
    
  </head>
  <body>
    <p>
      Dispon&#xed;vel na item da lista.
    </p>
  </body>
</html></richcontent>
</node>
<node CREATED="1413176596611" ID="ID_734090840" MODIFIED="1426127328514" TEXT="Configurar tag">
<richcontent TYPE="NOTE"><html>
  <head>
    
  </head>
  <body>
    <p>
      Dispon&#237;vel no bot&#227;o de bullet do item da lista. Consiste em configurar os atributos da tag e seus valores. Implementar atraves de fragmento.
    </p>
  </body>
</html></richcontent>
</node>
<node CREATED="1413176628490" ID="ID_1178628527" MODIFIED="1413177348847" TEXT="Excluir Tag">
<richcontent TYPE="NOTE"><html>
  <head>
    
  </head>
  <body>
    <p>
      Dispon&#xed;vel no item da lista.
    </p>
  </body>
</html></richcontent>
</node>
</node>
</node>
<node CREATED="1413175544128" ID="ID_965616845" MODIFIED="1426127191968" TEXT="Item de Tarefa">
<richcontent TYPE="NOTE"><html>
  <head>
    
  </head>
  <body>
    <p>
      Deve ter um &#237;cone &#224; esquerda indicando seu status (aberto [default], atrasado e conclu&#237;do)
    </p>
  </body>
</html></richcontent>
<node CREATED="1413225486447" ID="ID_1828188186" MODIFIED="1413226455404" TEXT="Label">
<richcontent TYPE="NOTE"><html>
  <head>
    
  </head>
  <body>
    <p>
      Ao tocar no label aciona um fragmento exibindo as propriedades da tarefa
    </p>
  </body>
</html></richcontent>
</node>
<node CREATED="1413225488303" ID="ID_154901464" MODIFIED="1413225491868" TEXT="Bullet menu">
<node CREATED="1413177429291" ID="ID_1958916217" MODIFIED="1413226663536" TEXT="Excluir tarefa">
<richcontent TYPE="NOTE"><html>
  <head>
    
  </head>
  <body>
    <p>
      Dispon&#xed;vel no bot&#xe3;o de bullet do item de tarefa.
    </p>
  </body>
</html></richcontent>
</node>
<node CREATED="1413177432367" ID="ID_1691466995" MODIFIED="1413226792676" TEXT="Renomear tarefa">
<richcontent TYPE="NOTE"><html>
  <head>
    
  </head>
  <body>
    <p>
      Dispon&#xed;vel no bot&#xe3;o de bullet do item de tarefa.
    </p>
  </body>
</html></richcontent>
</node>
<node CREATED="1413176960270" ID="ID_838313110" MODIFIED="1413253378546" TEXT="Atribuir tags #todo">
<richcontent TYPE="NOTE"><html>
  <head>
    
  </head>
  <body>
    <p>
      Dispon&#xed;vel no bot&#xe3;o de bullet do item de tarefa.
    </p>
  </body>
</html></richcontent>
</node>
<node CREATED="1413226905380" ID="ID_1124284753" MODIFIED="1426099690126" TEXT="Notas">
<richcontent TYPE="NOTE"><html>
  <head>
    
  </head>
  <body>
    <p>
      Quando uma tarefa estiver marcada com tag &quot;Note&quot; deve mostrar esta tag direto no menu de bullet da tarefa.
    </p>
  </body>
</html></richcontent>
</node>
</node>
</node>
<node CREATED="1413177168098" ID="ID_1977714887" MODIFIED="1426127203981" TEXT="Ambos (item de Tag e Tarefa)">
<richcontent TYPE="NOTE"><html>
  <head>
    
  </head>
  <body>
    <p>
      Devem possuir o nome do objeto e um bot&#xe3;o de bullet &#xe0; direita.
    </p>
  </body>
</html></richcontent>
</node>
</node>
</node>
<node CREATED="1413174759859" FOLDED="true" ID="ID_1404369176" MODIFIED="1426129509593" POSITION="right" TEXT="Planejamento">
<node CREATED="1413175927664" ID="ID_519550750" MODIFIED="1413227189599" TEXT="Definir prot&#xf3;tipo"/>
<node CREATED="1413254075985" ID="ID_370069275" MODIFIED="1413254085601" TEXT="Definir demais passos do planejamento"/>
<node CREATED="1413227189866" ID="ID_341479657" MODIFIED="1413227199023" TEXT="Montar layouts do prot&#xf3;tipo"/>
<node CREATED="1413227202514" ID="ID_178391480" MODIFIED="1413227227807" TEXT="Desenvolvimento #todo"/>
</node>
<node CREATED="1413227003252" ID="ID_1910835836" MODIFIED="1413253348076" POSITION="right" TEXT="#todo">
<node CREATED="1413177842788" ID="ID_408412777" MODIFIED="1413226989121" TEXT="Ver se h&#xe1; alguma situa&#xe7;&#xe3;o onde alguma parte do modelo n&#xe3;o pode ser manipulada">
<node CREATED="1426127638714" ID="ID_1252067476" MODIFIED="1426128038846" TEXT="Sub tarefas">
<richcontent TYPE="NOTE"><html>
  <head>
    
  </head>
  <body>
    <p>
      Adicionar, remover, alterar, listar e mudar a super tarefa.
    </p>
  </body>
</html></richcontent>
</node>
<node CREATED="1426127642928" ID="ID_623352022" MODIFIED="1426128043917" TEXT="Sub tags">
<richcontent TYPE="NOTE"><html>
  <head>
    
  </head>
  <body>
    <p>
      Adicionar, remover, alterar, listar e mudar a super tag.
    </p>
  </body>
</html></richcontent>
</node>
<node CREATED="1426127660008" ID="ID_1246604252" MODIFIED="1426127830657" TEXT="Acao de toque na tarefa deve ser condicional">
<richcontent TYPE="NOTE"><html>
  <head>
    
  </head>
  <body>
    <p>
      Quando a tarefa tiver subtarefas ao tocar abre as subtarefas. Quando nao tiver, abre suas propriedades. Indicar na lista quando uma tarefa possui subtarefas. View de propriedades da tarefa deve permitir acessar lista de subtarefas da tarefa.
    </p>
  </body>
</html></richcontent>
</node>
<node CREATED="1426129219280" ID="ID_1250484680" MODIFIED="1426129255298" TEXT="A&#xe7;ao de toque na tag deve ser condicional">
<richcontent TYPE="NOTE"><html>
  <head>
    
  </head>
  <body>
    <p>
      Ao tocar uma tag que nao foi atribuida a nada, nada deve acontecer. Formatar estas tags em cinza
    </p>
  </body>
</html></richcontent>
</node>
</node>
<node CREATED="1413227440296" ID="ID_1075176758" LINK="#ID_1016328759" MODIFIED="1426128449858" TEXT="Definir detalhes da lista principal">
<richcontent TYPE="NOTE"><html>
  <head>
    
  </head>
  <body>
    <p>
      Ao listar uma tag exatamente o que vai aparecer na lista principal?
    </p>
  </body>
</html></richcontent>
</node>
<node CREATED="1413227106547" ID="ID_1843635061" LINK="#ID_127904162" MODIFIED="1413253457965" TEXT="Busca avan&#xe7;ada"/>
<node CREATED="1413227623039" ID="ID_612091161" LINK="#ID_838313110" MODIFIED="1413227635559" TEXT="Atribuir tags"/>
<node CREATED="1413227639583" ID="ID_442762239" LINK="#ID_489957864" MODIFIED="1413253454142" TEXT="Acho que h&#xe1; outros itens eleg&#xed;veis aqui">
<richcontent TYPE="NOTE"><html>
  <head>
    
  </head>
  <body>
    <p>
      Ver atributos de tag
    </p>
  </body>
</html></richcontent>
</node>
<node CREATED="1413227371657" ID="ID_1509189898" LINK="#ID_315810424" MODIFIED="1413253461505" TEXT="Definir o que ser&#xe1; configur&#xe1;vel"/>
<node CREATED="1413227010188" ID="ID_613868989" LINK="#ID_452260561" MODIFIED="1413253454923" TEXT="Views de calend&#xe1;rio"/>
<node CREATED="1413227229610" ID="ID_817530887" LINK="#ID_178391480" MODIFIED="1413253360022" TEXT="Planejar passos do desenvolvimento"/>
</node>
</node>
</map>
