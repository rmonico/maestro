Maestro CLI
====

Um TODO list baseado em tags


Entidades
===

Task
---
id

supertask -&gt; Task

name


Tag
---
id

name


Attribute
---
id

name

tag -&gt; Tag

type -&gt; AttributeType


AttributeType
---
VIEW, FIXEDTAGLIST, REGEXTAGLIST, TEXT, DATETIME, INTEGER, GPS


TaskTag
---
id

task -&gt; Task

tag -&gt; Tag


TagProperty
---
id

taskTag -&gt; TaskTag

attribute -&gt; TagAttribute

value


Roadmap
===

Vers&atilde;o 0.1
---

*  tag add &lt;nome&gt;
*  tag ls
*  attr add &lt;nome tag&gt; &lt;nome atributo&gt; &lt;type&gt;
*  attr ls [nome tag]
*  task add &lt;nome&gt; \[ --supertaskid=&lt;super task id&gt; ] [ --tags=&lt;tags separadas por ,&gt; ]
*  task ls

Vers&atilde;o 0.2
---

* prop set &lt;task name id&gt; &lt;tag name&gt; &lt;attribute name&gt; &lt;attribute value&gt;
* task add, par&acirc;metro --tags: passa a receber o valor das propriedades das tags no formato: &lt;tag name&gt;:&lt;default property&gt;[&lt;attribute&gt;:&lt;property&gt;] (O [] &eacute; literal)
* O nome da default property &eacute; definido no MetaInf

task add "Nova tarefa com nota" -t=nota:Nota da tarefa

task add "Comprar p&atilde;o" -t=perto[local:padaria;proximidade:100 metros]

task add "Comprar p&atilde;o" -t=perto:valor da propriedade default[local:padaria;proximidade:100 metros]

Futuro
---
* Tag autom&aacute;tica com a data de cria&ccedil;&atilde;o da tarefa
    * Talvez montar tags desse tipo para ter todo o hist&oacute;rico da tarefa
* Fazer parser de query para task ls:
   --query="expressao"
  *  &lt;expressao&gt;: &lt;operando&gt; [&lt;operador bin&aacute;rio&gt; &lt;operando&gt;]
  *  &lt;operando&gt;: [ nome_tag | nome_tag(valor_atributo1,valor_atributo2...) | subtaskof @&lt;task id&gt; ]
  *  &lt;operador bin&aacute;rio&gt;: [ and | or ]