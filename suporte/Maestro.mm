<map version="0.9.0">
<!-- To view this file, download free mind mapping software FreeMind from http://freemind.sourceforge.net -->
<node CREATED="1413173006422" ID="ID_1709137031" MODIFIED="1413174745754" TEXT="Maestro">
<node CREATED="1413174747586" FOLDED="true" ID="ID_211431028" MODIFIED="1413176999806" POSITION="right" TEXT="Modelo">
<node CREATED="1413175726390" ID="ID_58940402" MODIFIED="1413176825800" TEXT="Object">
<richcontent TYPE="NOTE"><html>
  <head>
    
  </head>
  <body>
    <p>
      Super objeto pai de todos
    </p>
  </body>
</html>
</richcontent>
<node CREATED="1413175743324" ID="ID_1015149525" MODIFIED="1413175746196" TEXT="SubEntities">
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
<node CREATED="1413173285226" ID="ID_306946758" MODIFIED="1413175704562" TEXT="TagAttributeValueType (enum)">
<node CREATED="1413174372586" ID="ID_701489731" MODIFIED="1413175328719" TEXT="DRAWER">
<richcontent TYPE="NOTE"><html>
  <head>
    
  </head>
  <body>
    <p>
      Aplic&#225;vel a Tags apenas. N&#227;o recebe nada. Faz a tag aparecer na gaveta.
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
      Aplic&#225;vel a Tags apenas. Recebe uma lista de palavras separadas por espa&#231;o. Lista as tarefas que possuem todas as palavras informadas.
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
      Aplic&#225;vel a Tags apenas. Recebe uma lista de palavras separadas por espa&#231;o. Lista as tarefas que possuem pelo menos uma das palavras informadas.
    </p>
  </body>
</html></richcontent>
</node>
<node CREATED="1413173318854" ID="ID_149301598" MODIFIED="1413175357505" TEXT="NOTE">
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
      Aplic&#225;vel a Tags e Tarefas. Recebe uma URL. Mostra um link para a URL na lista quando a tarefa &#233; renderizada.
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
      Aplic&#225;vel a Tags e Tarefas. Recebe um inteiro que indica a prioridade da tarefa. Quanto menor mais priorit&#225;ria a tarefa &#233;.
    </p>
  </body>
</html></richcontent>
</node>
<node CREATED="1413174130806" ID="ID_419633634" MODIFIED="1413174137208" TEXT="Lembretes">
<node CREATED="1413173332896" ID="ID_1349417614" MODIFIED="1413175396759" TEXT="GPS">
<richcontent TYPE="NOTE"><html>
  <head>
    
  </head>
  <body>
    <p>
      Aplic&#225;vel a Tarefas apenas. Recebe um lat/lon e dist&#226;ncia. Aciona um lembrete quando o dispositivo estiver a dist&#226;ncia informada do lat/lon informado
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
      Aplic&#225;vel a Tarefas apenas. Receba uma data/hora, aviso_previo e sinc_google=yes/no. Faz a tarefa aparecer no view de calend&#225;rio e aciona um lembrete quando a hora do dispositivo chegar a data/hora - aviso_previo. Sincroniza a tarefa com o calend&#225;rio do google conforme valor informado.
    </p>
  </body>
</html></richcontent>
</node>
<node CREATED="1413174223060" ID="ID_21330408" MODIFIED="1413175416241" TEXT="PLACE">
<richcontent TYPE="NOTE"><html>
  <head>
    
  </head>
  <body>
    <p>
      Aplic&#225;vel a Tarefas apenas. Recebe um &quot;lugar&quot; gen&#233;rico (por exemplo farm&#225;cia, mercado, padaria, etc). Aciona um lembrete quando o dispositivo estiver pr&#243;ximo a um estabelecimento do tipo informado.
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
      Aplic&#225;vel a Tarefas apenas. Recebe um contato. Aciona um lembrete quando o dispositivo estiver pr&#243;ximo a pessoa (como?)
    </p>
  </body>
</html></richcontent>
</node>
</node>
<node CREATED="1413173343451" ID="ID_1090433808" MODIFIED="1413175444141" TEXT="ALIVE">
<richcontent TYPE="NOTE"><html>
  <head>
    
  </head>
  <body>
    <p>
      Aplic&#225;vel a Tags e Tarefas. Indica uma tag viva. O valor da tag ser&#225; um script de marcar/remover tags de tarefa mediante condi&#231;&#245;es (constantes no script tamb&#233;m)
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
      Aplic&#225;vel a Tags e Tarefas. Cor de fundo, cor da letra, formata&#231;&#227;o, etc
    </p>
  </body>
</html></richcontent>
</node>
<node CREATED="1413173769504" ID="ID_336645230" MODIFIED="1413175467578" TEXT="ALL_THESE_TAGS">
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
      Aplic&#225;vel a Tags apenas. Recebe uma lista de tags, devolve todas as tarefas que tiverem pelo menos uma das tags da lista
    </p>
  </body>
</html></richcontent>
</node>
<node CREATED="1413175213331" ID="ID_1806904022" MODIFIED="1413175479755" TEXT="PRIVATE">
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
      Aplic&#225;vel a Tarefa apenas. N&#227;o recebe nada. Deve mudar a formata&#231;&#227;o da tarefa na lista.
    </p>
  </body>
</html></richcontent>
</node>
<node CREATED="1413176647029" ID="ID_1428071589" MODIFIED="1413176703878" TEXT="ALL_TAGS">
<richcontent TYPE="NOTE"><html>
  <head>
    
  </head>
  <body>
    <p>
      Aplicavel a Tags apenas. N&#227;o recebe nada. Mostra todas as Tags existentes.
    </p>
  </body>
</html>
</richcontent>
</node>
<node CREATED="1413176650575" ID="ID_1836486583" MODIFIED="1413176735082" TEXT="ALL_TASKS">
<richcontent TYPE="NOTE"><html>
  <head>
    
  </head>
  <body>
    <p>
      Aplicavel a Tags apenas. N&#227;o recebe nada. Mostra todas as Tarefas existentes.
    </p>
  </body>
</html>
</richcontent>
</node>
<node CREATED="1413176656887" ID="ID_661977118" MODIFIED="1413176759985" TEXT="EVERYTHING">
<richcontent TYPE="NOTE"><html>
  <head>
    
  </head>
  <body>
    <p>
      Aplicavel a Tags apenas. N&#227;o recebe nada. Mostra todos os UserObject existentes.od
    </p>
  </body>
</html>
</richcontent>
</node>
<node CREATED="1413176705333" ID="ID_1863504962" MODIFIED="1413176846095" TEXT="SYSTEM_TAG">
<richcontent TYPE="NOTE"><html>
  <head>
    
  </head>
  <body>
    <p>
      Aplicavel a Tags apenas. N&#227;o recebe nada. Quando marcado com este atributo a tag n&#227;o fica dispon&#237;vel para o usu&#225;rio marcar tarefas com ela, e nem pode ser exclu&#237;da, renomeada ou configurada pelo usu&#225;rio.
    </p>
  </body>
</html>
</richcontent>
</node>
</node>
<node CREATED="1413173386855" ID="ID_314924194" MODIFIED="1413173502104" TEXT="TagProperty">
<node CREATED="1413173401538" ID="ID_1748073251" MODIFIED="1413173430913" TEXT="taskTag -&gt; TaskTag"/>
<node CREATED="1413173408570" ID="ID_997998676" MODIFIED="1413173425874" TEXT="attribute -&gt; TagAttribute"/>
<node CREATED="1413173476599" ID="ID_626605992" MODIFIED="1413173477477" TEXT="value"/>
</node>
</node>
<node CREATED="1413175750432" ID="ID_1641826651" MODIFIED="1413175756331" TEXT="Fields">
<node CREATED="1413175793859" ID="ID_1361721903" MODIFIED="1413175795075" TEXT="id"/>
<node CREATED="1413175795400" ID="ID_697473912" MODIFIED="1413175809370" TEXT="creator"/>
<node CREATED="1413175809574" ID="ID_1299957690" MODIFIED="1413175813528" TEXT="created_on"/>
<node CREATED="1413175829750" ID="ID_201613428" MODIFIED="1413175843310" TEXT="last_modifier">
<richcontent TYPE="NOTE"><html>
  <head>
    
  </head>
  <body>
    <p>
      &#218;ltima pessoa que modificou
    </p>
  </body>
</html></richcontent>
</node>
<node CREATED="1413175813747" ID="ID_1128051741" MODIFIED="1413175828784" TEXT="last_modified"/>
</node>
</node>
</node>
<node CREATED="1413174754407" ID="ID_979565566" MODIFIED="1413174758454" POSITION="right" TEXT="Funcionalidades">
<node CREATED="1413176603604" ID="ID_1609654143" MODIFIED="1413176606788" TEXT="Navega&#xe7;&#xe3;o">
<node CREATED="1413174782902" ID="ID_1265740557" MODIFIED="1413176610607" TEXT="Gaveta">
<richcontent TYPE="NOTE"><html>
  <head>
    
  </head>
  <body>
    <p>
      Mostrar as tags que possuam um TagAttributeValueType de Drawer
    </p>
  </body>
</html>
</richcontent>
</node>
<node CREATED="1413174779079" ID="ID_1430001074" MODIFIED="1413176610593" TEXT="Lista">
<richcontent TYPE="NOTE"><html>
  <head>
    
  </head>
  <body>
    <p>
      Inicialmente mostra as tarefas da tag selecionada na gaveta.
    </p>
  </body>
</html>
</richcontent>
</node>
<node CREATED="1413177034193" ID="ID_47252173" MODIFIED="1413177037768" TEXT="Calend&#xe1;rio"/>
</node>
<node CREATED="1413174797549" ID="ID_62375673" MODIFIED="1413177608584" TEXT="Barra r&#xe1;pida de tarefa">
<richcontent TYPE="NOTE"><html>
  <head>
    
  </head>
  <body>
    <p>
      Dever&#225; adicionar/procurar uma tarefa rapidamente
    </p>
  </body>
</html>
</richcontent>
</node>
<node CREATED="1413176617273" ID="ID_1426892700" MODIFIED="1413176623785" TEXT="Itens de lista">
<node CREATED="1413175512579" ID="ID_985477837" MODIFIED="1413177220875" TEXT="Item de lista de Tag">
<richcontent TYPE="NOTE"><html>
  <head>
    
  </head>
  <body>
    <p>
      Deve ter um &#237;cone para indicar que n&#227;o &#233; uma tarefa.
    </p>
  </body>
</html>
</richcontent>
</node>
<node CREATED="1413175544128" ID="ID_1315423697" MODIFIED="1413177327309" TEXT="Item de lista de Tarefa">
<richcontent TYPE="NOTE"><html>
  <head>
    
  </head>
  <body>
    <p>
      Deve ter um &#237;cone &#224; esquerda indicando seu status (aberto [default], atrasado e conclu&#237;do)
    </p>
  </body>
</html>
</richcontent>
</node>
<node CREATED="1413177168098" ID="ID_1906973330" MODIFIED="1413177195656" TEXT="Ambos">
<richcontent TYPE="NOTE"><html>
  <head>
    
  </head>
  <body>
    <p>
      Devem possuir o nome do objeto e um bot&#227;o de bullet &#224; direita.
    </p>
  </body>
</html>
</richcontent>
</node>
</node>
<node CREATED="1413176859268" ID="ID_921576524" MODIFIED="1413176866230" TEXT="Gerenciamento de Tag">
<node CREATED="1413176870892" ID="ID_1670012444" MODIFIED="1413177545743" TEXT="Adicionar tag">
<richcontent TYPE="NOTE"><html>
  <head>
    
  </head>
  <body>
    <p>
      Dispon&#237;vel no bot&#227;o de menu quando a gaveta estiver aberta. Est&#225; fun&#231;&#227;o s&#243; dever&#225; existir para criar tags da gaveta.
    </p>
  </body>
</html>
</richcontent>
</node>
<node CREATED="1413176586495" ID="ID_1285275892" MODIFIED="1413177360031" TEXT="Renomear Tag">
<richcontent TYPE="NOTE"><html>
  <head>
    
  </head>
  <body>
    <p>
      Dispon&#237;vel na item da lista.
    </p>
  </body>
</html>
</richcontent>
</node>
<node CREATED="1413176596611" ID="ID_1972703725" MODIFIED="1413177164725" TEXT="Configurar tag">
<richcontent TYPE="NOTE"><html>
  <head>
    
  </head>
  <body>
    <p>
      Dispon&#237;vel no bot&#227;o de bullet do item da lista. Consiste em configurar os atributos da tag e seus valores.
    </p>
  </body>
</html>
</richcontent>
</node>
<node CREATED="1413176628490" ID="ID_280210944" MODIFIED="1413177348847" TEXT="Excluir Tag">
<richcontent TYPE="NOTE"><html>
  <head>
    
  </head>
  <body>
    <p>
      Dispon&#237;vel no item da lista.
    </p>
  </body>
</html>
</richcontent>
</node>
</node>
<node CREATED="1413176941101" ID="ID_1535905969" MODIFIED="1413176959485" TEXT="Gerenciamento de Tarefa">
<node CREATED="1413177417190" ID="ID_750262841" MODIFIED="1413177575156" TEXT="Adicionar tarefa">
<richcontent TYPE="NOTE"><html>
  <head>
    
  </head>
  <body>
    <p>
      Disponivel na barra rapida de tarefa
    </p>
  </body>
</html>
</richcontent>
</node>
<node CREATED="1413177429291" ID="ID_1986887358" MODIFIED="1413177662276" TEXT="Excluir tarefa">
<richcontent TYPE="NOTE"><html>
  <head>
    
  </head>
  <body>
    <p>
      Dispon&#237;vel no bot&#227;o de bullet do item de tarefa.
    </p>
  </body>
</html>
</richcontent>
</node>
<node CREATED="1413177432367" ID="ID_950152206" MODIFIED="1413177671696" TEXT="Renomear tarefa">
<richcontent TYPE="NOTE"><html>
  <head>
    
  </head>
  <body>
    <p>
      Dispon&#237;vel no bot&#227;o de bullet do item de tarefa.
    </p>
  </body>
</html>
</richcontent>
</node>
<node CREATED="1413176960270" ID="ID_1656664346" MODIFIED="1413177688562" TEXT="Atribuir tags">
<richcontent TYPE="NOTE"><html>
  <head>
    
  </head>
  <body>
    <p>
      Dispon&#237;vel no bot&#227;o de bullet do item de tarefa.
    </p>
  </body>
</html>
</richcontent>
</node>
</node>
<node CREATED="1413177737252" ID="ID_771640522" MODIFIED="1413177746433" TEXT="TODO -- Planejamento">
<node CREATED="1413177748548" ID="ID_23215855" MODIFIED="1413177834162" TEXT="Organizar esta &#xe1;rvore por acionador">
<richcontent TYPE="NOTE"><html>
  <head>
    
  </head>
  <body>
    <p>
      Por exemplo, Adicionar tarefa vai para dentro de Item da lista de tarefas
    </p>
  </body>
</html>
</richcontent>
</node>
<node CREATED="1413177842788" ID="ID_408412777" MODIFIED="1413177899308" TEXT="Ver se h&#xe1; alguma situa&#xe7;&#xe3;o onde algo n&#xe3;o pode ser manipulado"/>
<node CREATED="1413177902017" ID="ID_1564164815" MODIFIED="1413177947481" TEXT="Quando uma tarefa estiver marcada com tag &quot;Note&quot; deve mostrar esta tag direto no menu de bullet da tarefa. Fazer um TagAttributeValue para isso"/>
</node>
</node>
<node CREATED="1413174759859" ID="ID_1404369176" MODIFIED="1413174766916" POSITION="right" TEXT="Planejamento">
<node CREATED="1413175927664" ID="ID_519550750" MODIFIED="1413175934091" TEXT="Prot&#xf3;tipo"/>
</node>
</node>
</map>
