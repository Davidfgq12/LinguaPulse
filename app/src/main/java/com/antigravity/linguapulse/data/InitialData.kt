package com.antigravity.linguapulse.data

object InitialData {
    fun getInitialCards(): List<Flashcard> {
        val list = mutableListOf<Flashcard>()

        // ==========================================
        // 1. DÍA A DÍA: CONECTORES Y NEXOS
        // ==========================================
        list.add(
            Flashcard(
                termEn = "However",
                meaningEs = "Sin embargo / No obstante",
                explanationEn = "Used to introduce a statement that contrasts with or seems to contradict something that has been said.",
                explanationEs = "Se utiliza para introducir un contraste formal con la idea anterior. Generalmente va seguido de una coma.",
                exampleEn = "I wanted to go for a run; however, it started raining heavily.",
                exampleEs = "Quería salir a correr; sin embargo, comenzó a llover intensamente.",
                category = Categories.DAILY,
                subcategory = Subcategories.CONNECTOR
            )
        )
        list.add(
            Flashcard(
                termEn = "Even though",
                meaningEs = "A pesar de que / Aunque",
                explanationEn = "Emphasizes that something is true in spite of another fact. Stronger than 'although'.",
                explanationEs = "Enfatiza que un hecho ocurre a pesar de una circunstancia adversa o contraria. Es más enfático que 'although'.",
                exampleEn = "Even though he was tired, he finished all his chores.",
                exampleEs = "A pesar de que estaba cansado, terminó todos sus quehaceres.",
                category = Categories.DAILY,
                subcategory = Subcategories.CONNECTOR
            )
        )
        list.add(
            Flashcard(
                termEn = "Meanwhile",
                meaningEs = "Mientras tanto",
                explanationEn = "Refers to the period of time between two events, or indicates something happening simultaneously.",
                explanationEs = "Indica que una acción está sucediendo al mismo tiempo que otra en un lugar o contexto diferente.",
                exampleEn = "The kids were playing in the yard; meanwhile, mom was preparing dinner.",
                exampleEs = "Los niños jugaban en el patio; mientras tanto, mamá preparaba la cena.",
                category = Categories.DAILY,
                subcategory = Subcategories.CONNECTOR
            )
        )
        list.add(
            Flashcard(
                termEn = "In addition",
                meaningEs = "Además / Sumado a esto",
                explanationEn = "Used to add another piece of information to what has already been said.",
                explanationEs = "Conector de adición para aportar información extra que refuerza lo expresado anteriormente.",
                exampleEn = "The hotel offers free breakfast. In addition, there is a 24-hour gym.",
                exampleEs = "El hotel ofrece desayuno gratis. Además, cuenta con un gimnasio abierto las 24 horas.",
                category = Categories.DAILY,
                subcategory = Subcategories.CONNECTOR
            )
        )
        list.add(
            Flashcard(
                termEn = "Therefore",
                meaningEs = "Por lo tanto / Por consiguiente",
                explanationEn = "Used as a logical result or conclusion of that which is previously stated.",
                explanationEs = "Indica una consecuencia lógica directa o conclusión de un hecho anterior.",
                exampleEn = "We missed the last bus; therefore, we had to take a taxi home.",
                exampleEs = "Perdimos el último autobús; por lo tanto, tuvimos que tomar un taxi a casa.",
                category = Categories.DAILY,
                subcategory = Subcategories.CONNECTOR
            )
        )
        list.add(
            Flashcard(
                termEn = "On the other hand",
                meaningEs = "Por otro lado / Por otra parte",
                explanationEn = "Introduces a contrasting point of view, fact, or alternative perspective.",
                explanationEs = "Introduce un punto de vista alternativo o una perspectiva en contraste.",
                exampleEn = "Living in the city is exciting; on the other hand, it can be very noisy.",
                exampleEs = "Vivir en la ciudad es emocionante; por otra parte, puede ser muy ruidoso.",
                category = Categories.DAILY,
                subcategory = Subcategories.CONNECTOR
            )
        )
        list.add(
            Flashcard(
                termEn = "As long as",
                meaningEs = "Siempre y cuando / Mientras que",
                explanationEn = "Sets a condition that must be met for something else to happen.",
                explanationEs = "Establece una condición que debe cumplirse para que otra cosa ocurra o se mantenga.",
                exampleEn = "You can borrow my car as long as you return it with a full tank.",
                exampleEs = "Puedes tomar prestado mi auto siempre y cuando lo regreses con el tanque lleno.",
                category = Categories.DAILY,
                subcategory = Subcategories.CONNECTOR
            )
        )
        list.add(
            Flashcard(
                termEn = "In spite of",
                meaningEs = "A pesar de",
                explanationEn = "Followed by a noun or gerund (-ing) to show contrast without being affected by the obstacle.",
                explanationEs = "Siempre va seguido de un sustantivo o gerundio (-ing) para denotar que algo se logró superando un obstáculo.",
                exampleEn = "In spite of the heavy traffic, we arrived on time.",
                exampleEs = "A pesar del tráfico pesado, llegamos a tiempo.",
                category = Categories.DAILY,
                subcategory = Subcategories.CONNECTOR
            )
        )
        list.add(
            Flashcard(
                termEn = "Actually",
                meaningEs = "De hecho / En realidad",
                explanationEn = "Used to correct a misconception or to emphasize what is really true. (False friend: does not mean 'currently').",
                explanationEs = "¡Falso amigo! No significa 'actualmente'. Se usa para corregir una idea errónea o confirmar la realidad de los hechos.",
                exampleEn = "I thought he was French, but actually, he is Belgian.",
                exampleEs = "Pensé que era francés, pero en realidad es belga.",
                category = Categories.DAILY,
                subcategory = Subcategories.CONNECTOR
            )
        )
        list.add(
            Flashcard(
                termEn = "In other words",
                meaningEs = "En otras palabras / Dicho de otro modo",
                explanationEn = "Used to rephrase something to make it clearer or simpler to understand.",
                explanationEs = "Se usa para reformular una frase o explicación compleja y hacerla más sencilla.",
                exampleEn = "The flight is delayed by five hours; in other words, we won't arrive until tomorrow.",
                exampleEs = "El vuelo se retrasó cinco horas; en otras palabras, no llegaremos hasta mañana.",
                category = Categories.DAILY,
                subcategory = Subcategories.CONNECTOR
            )
        )
        list.add(
            Flashcard(
                termEn = "As a matter of fact",
                meaningEs = "De hecho / En efecto",
                explanationEn = "Adds more detail or confirms the truth of a previous statement with conviction.",
                explanationEs = "Añade un detalle contundente que confirma la certeza de lo que se acaba de decir.",
                exampleEn = "Have you seen John? As a matter of fact, I just spoke to him a minute ago.",
                exampleEs = "¿Has visto a John? De hecho, acabo de hablar con él hace un minuto.",
                category = Categories.DAILY,
                subcategory = Subcategories.CONNECTOR
            )
        )
        list.add(
            Flashcard(
                termEn = "Otherwise",
                meaningEs = "De lo contrario / Si no",
                explanationEn = "Indicates what would happen if the specified condition or action were not carried out.",
                explanationEs = "Indica la consecuencia negativa que ocurriría si no se hace lo indicado.",
                exampleEn = "Set your alarm clock; otherwise, you will oversleep.",
                exampleEs = "Pon la alarma del reloj; de lo contrario, te quedarás dormido.",
                category = Categories.DAILY,
                subcategory = Subcategories.CONNECTOR
            )
        )

        // ==========================================
        // 1. DÍA A DÍA: VERBOS COMPUESTOS (PHRASAL VERBS)
        // ==========================================
        list.add(
            Flashcard(
                termEn = "Figure out",
                meaningEs = "Descifrar / Resolver / Entender cómo funciona",
                explanationEn = "To solve a problem, understand something difficult, or discover the solution through thought.",
                explanationEs = "Llegar a comprender algo o hallar la solución a un problema tras pensarlo o investigarlo.",
                exampleEn = "I can't figure out why this microwave isn't heating.",
                exampleEs = "No logro descifrar por qué este microondas no calienta.",
                category = Categories.DAILY,
                subcategory = Subcategories.PHRASAL_VERB
            )
        )
        list.add(
            Flashcard(
                termEn = "Look into",
                meaningEs = "Investigar / Averiguar",
                explanationEn = "To examine the facts about a problem, situation, or request.",
                explanationEs = "Revisar los detalles o investigar a fondo un asunto antes de dar una respuesta definitiva.",
                exampleEn = "The customer service agent promised to look into the delivery delay.",
                exampleEs = "El agente de servicio al cliente prometió investigar el retraso en la entrega.",
                category = Categories.DAILY,
                subcategory = Subcategories.PHRASAL_VERB
            )
        )
        list.add(
            Flashcard(
                termEn = "Run out of",
                meaningEs = "Quedarse sin / Agotársele a uno algo",
                explanationEn = "To finish the supply of something so that none is left.",
                explanationEs = "Agotar la existencia de algo (gasolina, tiempo, café, paciencia).",
                exampleEn = "We ran out of milk, so I need to go to the grocery store.",
                exampleEs = "Nos quedamos sin leche, así que necesito ir a la tienda.",
                category = Categories.DAILY,
                subcategory = Subcategories.PHRASAL_VERB
            )
        )
        list.add(
            Flashcard(
                termEn = "Call off",
                meaningEs = "Cancelar (un evento o plan)",
                explanationEn = "To cancel an event, meeting, or activity that was previously arranged.",
                explanationEs = "Cancelar formalmente un evento, partido, fiesta o cita ya programada.",
                exampleEn = "They decided to call off the soccer match due to the storm.",
                exampleEs = "Decidieron cancelar el partido de fútbol debido a la tormenta.",
                category = Categories.DAILY,
                subcategory = Subcategories.PHRASAL_VERB
            )
        )
        list.add(
            Flashcard(
                termEn = "Put off",
                meaningEs = "Posponer / Postergar",
                explanationEn = "To postpone something to a later time or date; to procrastinate.",
                explanationEs = "Aplazar una tarea o compromiso para más tarde o para otro día.",
                exampleEn = "Don't put off until tomorrow what you can do today.",
                exampleEs = "No pospongas para mañana lo que puedes hacer hoy.",
                category = Categories.DAILY,
                subcategory = Subcategories.PHRASAL_VERB
            )
        )
        list.add(
            Flashcard(
                termEn = "Bring up",
                meaningEs = "Mencionar un tema / Sacar a colación",
                explanationEn = "To mention or introduce a topic in conversation.",
                explanationEs = "Sacar un tema a relucir en medio de una conversación.",
                exampleEn = "I didn't want to bring up the bad news during dinner.",
                exampleEs = "No quería sacar a colación las malas noticias durante la cena.",
                category = Categories.DAILY,
                subcategory = Subcategories.PHRASAL_VERB
            )
        )
        list.add(
            Flashcard(
                termEn = "Turn out",
                meaningEs = "Resultar ser / Salir al final de cierta manera",
                explanationEn = "To happen in a particular way or have a particular result, often unexpected.",
                explanationEs = "Describir el desenlace de un evento, usualmente con un giro inesperado o positivo.",
                exampleEn = "The weather was cloudy, but it turned out to be a wonderful day.",
                exampleEs = "El clima estaba nublado, pero terminó resultando un día maravilloso.",
                category = Categories.DAILY,
                subcategory = Subcategories.PHRASAL_VERB
            )
        )
        list.add(
            Flashcard(
                termEn = "Come across",
                meaningEs = "Toparse con / Encontrar por casualidad",
                explanationEn = "To find or encounter someone or something by chance.",
                explanationEs = "Encontrar algo o a alguien de forma inesperada o fortuita.",
                exampleEn = "I came across an old family photo album while cleaning the attic.",
                exampleEs = "Me topé con un viejo álbum de fotos familiares mientras limpiaba el ático.",
                category = Categories.DAILY,
                subcategory = Subcategories.PHRASAL_VERB
            )
        )
        list.add(
            Flashcard(
                termEn = "Get along with",
                meaningEs = "Llevarse bien con alguien",
                explanationEn = "To have a harmonious, friendly relationship with someone.",
                explanationEs = "Tener una buena relación de convivencia o amistad con otra persona.",
                exampleEn = "Do you get along well with your new neighbors?",
                exampleEs = "¿Te llevas bien con tus nuevos vecinos?",
                category = Categories.DAILY,
                subcategory = Subcategories.PHRASAL_VERB
            )
        )
        list.add(
            Flashcard(
                termEn = "Catch up",
                meaningEs = "Ponerse al día (conversar o nivelarse)",
                explanationEn = "To reach the same standard or status, or to update each other on recent life events.",
                explanationEs = "Hablar con un amigo para enterarse de lo que ha pasado en sus vidas, o ponerse al corriente.",
                exampleEn = "It's been months! Let's grab a coffee and catch up.",
                exampleEs = "¡Han pasado meses! Tomémonos un café para ponernos al día.",
                category = Categories.DAILY,
                subcategory = Subcategories.PHRASAL_VERB
            )
        )
        list.add(
            Flashcard(
                termEn = "Drop by",
                meaningEs = "Pasar a visitar rápidamente / Caer de improvisto",
                explanationEn = "To pay a brief or informal visit without much advance notice.",
                explanationEs = "Hacer una visita breve e informal a casa o trabajo de alguien.",
                exampleEn = "Feel free to drop by whenever you are in the neighborhood.",
                exampleEs = "Siéntete libre de pasar a visitarme cuando estés por el vecindario.",
                category = Categories.DAILY,
                subcategory = Subcategories.PHRASAL_VERB
            )
        )
        list.add(
            Flashcard(
                termEn = "Look forward to",
                meaningEs = "Esperar con ansias / Tener muchas ganas de",
                explanationEn = "To feel excited and pleased about something that is going to happen. Note: followed by -ing!",
                explanationEs = "Estar muy emocionado por un evento futuro. ¡Ojo! Siempre va seguido de verbo con '-ing'.",
                exampleEn = "I'm really looking forward to visiting New York next month.",
                exampleEs = "Tengo muchas ganas de visitar Nueva York el próximo mes.",
                category = Categories.DAILY,
                subcategory = Subcategories.PHRASAL_VERB
            )
        )

        // ==========================================
        // 1. DÍA A DÍA: ORACIONES Y MODISMOS
        // ==========================================
        list.add(
            Flashcard(
                termEn = "Hit the nail on the head",
                meaningEs = "Dar en el clavo / Acertar con precisión",
                explanationEn = "To describe exactly what is causing a situation or say something completely accurate.",
                explanationEs = "Expresión idiomática para decir que alguien ha expresado la verdad exacta de una situación.",
                exampleEn = "When you said communication was the issue, you hit the nail on the head.",
                exampleEs = "Cuando dijiste que el problema era la comunicación, diste en el clavo.",
                category = Categories.DAILY,
                subcategory = Subcategories.SENTENCE
            )
        )
        list.add(
            Flashcard(
                termEn = "Let's call it a day",
                meaningEs = "Demos por terminado el día / Paremos aquí",
                explanationEn = "Used to decide to stop working on an activity for the rest of the day.",
                explanationEs = "Frase común al final de una jornada o sesión para acordar que ya se hizo suficiente por hoy.",
                exampleEn = "We've made good progress on the report. Let's call it a day.",
                exampleEs = "Avanzamos bien en el informe. Demos por terminado el día por hoy.",
                category = Categories.DAILY,
                subcategory = Subcategories.SENTENCE
            )
        )
        list.add(
            Flashcard(
                termEn = "Out of the blue",
                meaningEs = "De la nada / Totalmente inesperado",
                explanationEn = "Something that happens completely by surprise and without any warning.",
                explanationEs = "Algo que ocurre de manera totalmente imprevista, como un rayo en cielo despejado.",
                exampleEn = "Out of the blue, my high school best friend called me yesterday.",
                exampleEs = "De la nada, mi mejor amigo de la secundaria me llamó ayer.",
                category = Categories.DAILY,
                subcategory = Subcategories.SENTENCE
            )
        )
        list.add(
            Flashcard(
                termEn = "It slipped my mind",
                meaningEs = "Se me pasó por completo / Se me olvidó",
                explanationEn = "An apology or admission that you forgot to do something or forgot a piece of information.",
                explanationEs = "Forma muy natural y común de admitir que algo se te olvidó sin mala intención.",
                exampleEn = "I was supposed to buy bread, but it completely slipped my mind.",
                exampleEs = "Se suponía que compraría pan, pero se me pasó por completo.",
                category = Categories.DAILY,
                subcategory = Subcategories.SENTENCE
            )
        )
        list.add(
            Flashcard(
                termEn = "Up in the air",
                meaningEs = "En el aire / Sin definir todavía",
                explanationEn = "Describes a plan or decision that has not yet been finalized or resolved.",
                explanationEs = "Describe un plan, acuerdo o viaje que aún no está confirmado ni tiene fecha fija.",
                exampleEn = "Our vacation plans are still up in the air until my boss approves the time off.",
                exampleEs = "Nuestros planes de vacaciones aún están en el aire hasta que mi jefe apruebe los días libres.",
                category = Categories.DAILY,
                subcategory = Subcategories.SENTENCE
            )
        )
        list.add(
            Flashcard(
                termEn = "Bite the bullet",
                meaningEs = "Hacer de tripas corazón / Afrontar una situación difícil",
                explanationEn = "To decide to do something difficult, unpleasant, or painful that one has been hesitating over.",
                explanationEs = "Afrontar con valentía algo inevitable que habías estado evitando o posponiendo.",
                exampleEn = "I hate going to the dentist, but I just need to bite the bullet and go.",
                exampleEs = "Detesto ir al dentista, pero tendré que hacer de tripas corazón e ir.",
                category = Categories.DAILY,
                subcategory = Subcategories.SENTENCE
            )
        )
        list.add(
            Flashcard(
                termEn = "Take it with a grain of salt",
                meaningEs = "Tomarlo con pinzas / No creerlo al 100%",
                explanationEn = "To view something with skepticism and not accept it as completely true or reliable.",
                explanationEs = "Consejo para no creerse un rumor, exageración o noticia sin verificarla antes.",
                exampleEn = "Online reviews can be misleading, so take them with a grain of salt.",
                exampleEs = "Las reseñas en internet pueden engañar, así que tómalas con pinzas.",
                category = Categories.DAILY,
                subcategory = Subcategories.SENTENCE
            )
        )
        list.add(
            Flashcard(
                termEn = "Under the weather",
                meaningEs = "Indispuesto / No sentirse muy bien de salud",
                explanationEn = "Feeling slightly unwell, sick, or low in energy.",
                explanationEs = "Expresión muy común para avisar que tienes un malestar leve (resfriado o cansancio).",
                exampleEn = "I won't be able to join lunch today; I'm feeling a bit under the weather.",
                exampleEs = "No podré acompañarlos al almuerzo hoy; me siento un poco indispuesto.",
                category = Categories.DAILY,
                subcategory = Subcategories.SENTENCE
            )
        )

        // ==========================================
        // 2. VENTAS B2B TECH: CONECTORES EJECUTIVOS
        // ==========================================
        list.add(
            Flashcard(
                termEn = "That being said",
                meaningEs = "Dicho esto / No obstante / Aun así",
                explanationEn = "Used in executive business discussions to transition from an acknowledgment to a contrasting consideration.",
                explanationEs = "Transición corporativa esencial para reconocer un punto positivo antes de introducir un matiz crítico.",
                exampleEn = "Our current cloud stack is stable. That being said, data egress costs are escalating rapidly.",
                exampleEs = "Nuestra infraestructura de nube actual es estable. Dicho esto, los costos de transferencia de datos están subiendo rápido.",
                category = Categories.B2B_SALES,
                subcategory = Subcategories.CONNECTOR
            )
        )
        list.add(
            Flashcard(
                termEn = "Moving forward",
                meaningEs = "De cara al futuro / En adelante / Como siguiente paso",
                explanationEn = "Standard business transition to shift conversation focus from past challenges to upcoming actions and roadmap.",
                explanationEs = "Fórmula clave en reuniones de venta para dejar de hablar de problemas pasados y centrarse en el plan de acción.",
                exampleEn = "Moving forward, our top priority will be optimizing our real-time inference latency.",
                exampleEs = "De cara al futuro, nuestra máxima prioridad será optimizar la latencia de inferencia en tiempo real.",
                category = Categories.B2B_SALES,
                subcategory = Subcategories.CONNECTOR
            )
        )
        list.add(
            Flashcard(
                termEn = "With that in mind",
                meaningEs = "Teniendo eso en cuenta / Con base en ello",
                explanationEn = "Connects a previously identified client pain point directly to your proposed architectural solution.",
                explanationEs = "Conecta directamente la necesidad detectada en el cliente con la solución o arquitectura que vas a proponer.",
                exampleEn = "You mentioned strict compliance requirements. With that in mind, our solution offers dedicated tenancy.",
                exampleEs = "Mencionó estrictos requerimientos de cumplimiento. Con base en ello, nuestra solución ofrece tenencia dedicada.",
                category = Categories.B2B_SALES,
                subcategory = Subcategories.CONNECTOR
            )
        )
        list.add(
            Flashcard(
                termEn = "From an architectural standpoint",
                meaningEs = "Desde la perspectiva arquitectónica / técnica",
                explanationEn = "Used when addressing CTOs, Chief Data Officers, or Lead Architects to pivot into technical merits.",
                explanationEs = "Frase de alto impacto técnico para dirigirse a arquitectos de software, CTOs y directores de ingeniería.",
                exampleEn = "From an architectural standpoint, decoupling storage and compute drastically simplifies scalability.",
                exampleEs = "Desde la perspectiva arquitectónica, desacoplar el almacenamiento del cómputo simplifica drásticamente la escalabilidad.",
                category = Categories.B2B_SALES,
                subcategory = Subcategories.CONNECTOR
            )
        )
        list.add(
            Flashcard(
                termEn = "In terms of ROI",
                meaningEs = "En términos de Retorno de Inversión (ROI)",
                explanationEn = "Signals to CFOs and financial buyers that you are quantifying the tangible business value of the platform.",
                explanationEs = "Indica al comprador financiero (CFO, VP) que vas a justificar la inversión con métricas cuantificables.",
                exampleEn = "In terms of ROI, automated pipeline orchestration pays for itself within six months.",
                exampleEs = "En términos de retorno de inversión, la orquestación automatizada de pipelines se amortiza en seis meses.",
                category = Categories.B2B_SALES,
                subcategory = Subcategories.CONNECTOR
            )
        )
        list.add(
            Flashcard(
                termEn = "To put it into perspective",
                meaningEs = "Para ponerlo en contexto / Para dimensionarlo",
                explanationEn = "Helps client executives comprehend the scale, impact, or cost savings by offering a vivid comparison.",
                explanationEs = "Permite al cliente visualizar el impacto real de una cifra técnica o económica comparándola con algo tangible.",
                exampleEn = "To put it into perspective, eliminating that query bottleneck saves your analytics team 120 hours per week.",
                exampleEs = "Para ponerlo en contexto, eliminar ese cuello de botella en consultas le ahorra a su equipo 120 horas por semana.",
                category = Categories.B2B_SALES,
                subcategory = Subcategories.CONNECTOR
            )
        )
        list.add(
            Flashcard(
                termEn = "On top of that",
                meaningEs = "Por si fuera poco / Además de eso",
                explanationEn = "Used to stack additional high-value enterprise features or cost advantages during a pitch.",
                explanationEs = "Se usa en el pitch comercial para apilar beneficios de valor agregado que diferencian tu solución de la competencia.",
                exampleEn = "We offer 99.99% uptime SLA. On top of that, end-to-end encryption keys remain strictly under your control.",
                exampleEs = "Ofrecemos SLA del 99.99% de disponibilidad. Por si fuera poco, las llaves de cifrado quedan bajo su control exclusivo.",
                category = Categories.B2B_SALES,
                subcategory = Subcategories.CONNECTOR
            )
        )
        list.add(
            Flashcard(
                termEn = "In line with your roadmap",
                meaningEs = "Alineado con su hoja de ruta / plan estratégico",
                explanationEn = "Validates that your technology directly supports the customer's strategic quarterly or yearly milestones.",
                explanationEs = "Demuestra que entiendes los objetivos del cliente y que tu software encaja en sus prioridades inmediatas.",
                exampleEn = "In line with your roadmap for Q4, our AI agent accelerator speeds up time-to-market by 40%.",
                exampleEs = "Alineado con su hoja de ruta para el cuarto trimestre, nuestro acelerador de agentes de IA agiliza el tiempo al mercado un 40%.",
                category = Categories.B2B_SALES,
                subcategory = Subcategories.CONNECTOR
            )
        )
        list.add(
            Flashcard(
                termEn = "As far as governance is concerned",
                meaningEs = "En lo que respecta al gobierno (de datos / seguridad)",
                explanationEn = "Initiates discussion around enterprise compliance, data lineage, role-based access control, and auditing.",
                explanationEs = "Abre el diálogo sobre políticas corporativas, linaje de datos, control de acceso por roles y auditorías.",
                exampleEn = "As far as governance is concerned, our vector database logs every API call for strict audit trails.",
                exampleEs = "En lo que respecta al gobierno, nuestra base de datos vectorial registra cada llamada API para auditorías estrictas.",
                category = Categories.B2B_SALES,
                subcategory = Subcategories.CONNECTOR
            )
        )

        // ==========================================
        // 2. VENTAS B2B TECH: VERBOS COMPUESTOS (PHRASAL VERBS)
        // ==========================================
        list.add(
            Flashcard(
                termEn = "Drill down",
                meaningEs = "Profundizar / Entrar en el detalle minucioso",
                explanationEn = "To examine data or an issue in more depth, descending into granular detail.",
                explanationEs = "Pasar de una visión macro a analizar los números, métricas o arquitectura a nivel granular.",
                exampleEn = "Let's drill down into the compute utilization metrics across your Kubernetes clusters.",
                exampleEs = "Profundicemos en las métricas de utilización de cómputo en sus clústeres de Kubernetes.",
                category = Categories.B2B_SALES,
                subcategory = Subcategories.PHRASAL_VERB
            )
        )
        list.add(
            Flashcard(
                termEn = "Scale up / Scale out",
                meaningEs = "Escalar verticalmente (más potencia) / Escalar horizontalmente (más nodos)",
                explanationEn = "'Scale up' means adding more CPU/RAM to a machine; 'scale out' means adding more nodes or instances.",
                explanationEs = "Concepto fundamental en Cloud: Scale up es aumentar capacidad al mismo servidor; Scale out es sumar más servidores.",
                exampleEn = "Our distributed engine allows your pipeline to scale out dynamically during high-traffic peaks.",
                exampleEs = "Nuestro motor distribuido permite a su pipeline escalar horizontalmente de forma dinámica ante picos de tráfico.",
                category = Categories.B2B_SALES,
                subcategory = Subcategories.PHRASAL_VERB
            )
        )
        list.add(
            Flashcard(
                termEn = "Ramp up",
                meaningEs = "Acelerar / Incrementar el ritmo o adopción",
                explanationEn = "To increase the level, speed, or volume of activity or enterprise adoption.",
                explanationEs = "Aumentar gradualmente el uso, capacidad de procesamiento o capacitación de usuarios en una nueva herramienta.",
                exampleEn = "Once the pilot finishes, we will ramp up user onboarding across all business units.",
                exampleEs = "Una vez concluya la prueba piloto, aceleraremos la incorporación de usuarios en todas las unidades de negocio.",
                category = Categories.B2B_SALES,
                subcategory = Subcategories.PHRASAL_VERB
            )
        )
        list.add(
            Flashcard(
                termEn = "Sign off on",
                meaningEs = "Aprobar formalmente / Dar el visto bueno",
                explanationEn = "To give official approval to something, usually written or formal executive sign-off.",
                explanationEs = "Obtener la firma o aprobación formal de un decisor (CISO, CTO, Director de Compras).",
                exampleEn = "Has the Chief Information Security Officer (CISO) signed off on the architecture proposal?",
                exampleEs = "¿El Director de Seguridad de la Información (CISO) ya dio el visto bueno a la propuesta de arquitectura?",
                category = Categories.B2B_SALES,
                subcategory = Subcategories.PHRASAL_VERB
            )
        )
        list.add(
            Flashcard(
                termEn = "Touch base",
                meaningEs = "Ponerse en contacto brevemente / Coordinar",
                explanationEn = "To talk with someone briefly to check progress or establish contact.",
                explanationEs = "Contacto rápido y profesional entre vendedor y cliente para revisar avances sin saturar la agenda.",
                exampleEn = "Let's touch base early next week after your data engineering team reviews the API specs.",
                exampleEs = "Coordinemos una llamada breve a inicios de la próxima semana cuando sus ingenieros de datos revisen la API.",
                category = Categories.B2B_SALES,
                subcategory = Subcategories.PHRASAL_VERB
            )
        )
        list.add(
            Flashcard(
                termEn = "Double down on",
                meaningEs = "Apostar fuertemente por / Redoblar esfuerzos en",
                explanationEn = "To commit more heavily to a strategy, technology stack, or investment.",
                explanationEs = "Invertir más recursos y compromiso en una tecnología o iniciativa que ya está demostrando resultados.",
                exampleEn = "Enterprise leaders are doubling down on generative AI to boost developer productivity.",
                exampleEs = "Los líderes empresariales están redoblando esfuerzos en IA generativa para impulsar la productividad de sus desarrolladores.",
                category = Categories.B2B_SALES,
                subcategory = Subcategories.PHRASAL_VERB
            )
        )
        list.add(
            Flashcard(
                termEn = "Spin up",
                meaningEs = "Levantar / Desplegar instancias o servicios en la nube",
                explanationEn = "To instantiate, deploy, or initialize a cloud virtual machine, database, or container cluster.",
                explanationEs = "Verbo técnico habitual para desplegar un nuevo servidor, contenedor o clúster de cómputo en segundos.",
                exampleEn = "With our Terraform modules, your engineers can spin up an isolated test cluster in five minutes.",
                exampleEs = "Con nuestros módulos de Terraform, sus ingenieros pueden levantar un clúster de pruebas aislado en cinco minutos.",
                category = Categories.B2B_SALES,
                subcategory = Subcategories.PHRASAL_VERB
            )
        )
        list.add(
            Flashcard(
                termEn = "Flesh out",
                meaningEs = "Desarrollar en detalle / Dar cuerpo a una idea",
                explanationEn = "To add substance, details, or architectural specifics to a preliminary idea or concept.",
                explanationEs = "Completar con detalles técnicos una propuesta preliminar antes de enviarla al comité de compras.",
                exampleEn = "We need to flesh out the disaster recovery plan before submitting the RFP response.",
                exampleEs = "Necesitamos detallar a fondo el plan de recuperación ante desastres antes de entregar la propuesta técnica.",
                category = Categories.B2B_SALES,
                subcategory = Subcategories.PHRASAL_VERB
            )
        )
        list.add(
            Flashcard(
                termEn = "Phase out",
                meaningEs = "Dar de baja gradualmente / Descontinuar por etapas",
                explanationEn = "To gradually stop using a legacy system, platform, or service over time.",
                explanationEs = "Retirar de forma progresiva un sistema heredado (legacy) sin interrumpir la operación del negocio.",
                exampleEn = "Our migration plan allows you to phase out your on-premise data warehouse without downtime.",
                exampleEs = "Nuestro plan de migración les permite descontinuar su almacén de datos local progresivamente y sin caídas.",
                category = Categories.B2B_SALES,
                subcategory = Subcategories.PHRASAL_VERB
            )
        )
        list.add(
            Flashcard(
                termEn = "Buy into",
                meaningEs = "Comprar la idea / Convencerse del valor",
                explanationEn = "To accept, believe in, or become convinced of a proposed technical vision or strategy.",
                explanationEs = "Lograr que los stakeholders internos se convenzan de adoptar un nuevo paradigma o tecnología.",
                exampleEn = "It is crucial that the business analysts buy into this self-service analytics model.",
                exampleEs = "Es fundamental que los analistas de negocio compren la idea de este modelo de analítica de autoservicio.",
                category = Categories.B2B_SALES,
                subcategory = Subcategories.PHRASAL_VERB
            )
        )

        // ==========================================
        // 2. VENTAS B2B TECH: ORACIONES, PREGUNTAS Y OBJECIONES
        // ==========================================
        list.add(
            Flashcard(
                termEn = "How are you currently orchestrating data pipelines across multi-cloud environments?",
                meaningEs = "¿Cómo están orquestando actualmente sus pipelines de datos en entornos multi-nube?",
                explanationEn = "Discovery question that uncovers complexity, fragmentation, and tool fatigue in the prospect's data infrastructure.",
                explanationEs = "Pregunta de descubrimiento clave para revelar fricción en gestión de datos, silos y falta de observabilidad.",
                exampleEn = "How are you currently orchestrating data pipelines across multi-cloud environments? Are you maintaining Airflow in-house?",
                exampleEs = "¿Cómo están orquestando actualmente sus pipelines de datos en entornos multi-nube? ¿Mantienen Airflow internamente?",
                category = Categories.B2B_SALES,
                subcategory = Subcategories.SENTENCE
            )
        )
        list.add(
            Flashcard(
                termEn = "What is your main bottleneck when taking custom LLMs from experimentation into production?",
                meaningEs = "¿Cuál es su principal cuello de botella al llevar modelos LLM de experimentación a producción?",
                explanationEn = "High-impact AI discovery question focused on latency, token costs, evaluation, or GPU availability.",
                explanationEs = "Pregunta consultiva de alto nivel en IA para detectar dolores de latencia, costo de tokens o GPU throttling.",
                exampleEn = "What is your main bottleneck when taking custom LLMs into production? Is it fine-tuning costs or inference latency?",
                exampleEs = "¿Cuál es su principal cuello de botella al llevar LLMs a producción? ¿Los costos de fine-tuning o la latencia de inferencia?",
                category = Categories.B2B_SALES,
                subcategory = Subcategories.SENTENCE
            )
        )
        list.add(
            Flashcard(
                termEn = "By unifying your data lake and warehouse, you eliminate ETL friction and lower egress costs significantly.",
                meaningEs = "Al unificar su data lake y warehouse, eliminan la fricción de ETL y reducen significativamente costos de egress.",
                explanationEn = "Value proposition statement positioning Modern Data Stack and Lakehouse architectures against legacy silos.",
                explanationEs = "Declaración de valor que conecta arquitectura moderna con ahorro monetario tangible para la empresa.",
                exampleEn = "By unifying your data lake and warehouse into a single governance layer, you eliminate ETL friction and lower egress costs.",
                exampleEs = "Al unificar su data lake y warehouse en una sola capa de gobierno, eliminan la fricción de ETL y bajan costos de egress.",
                category = Categories.B2B_SALES,
                subcategory = Subcategories.SENTENCE
            )
        )
        list.add(
            Flashcard(
                termEn = "I completely understand your security concerns; let me demonstrate how our customer-managed keys ensure compliance.",
                meaningEs = "Entiendo perfectamente sus inquietudes de seguridad; permítame mostrarle cómo las llaves gestionadas por el cliente garantizan el cumplimiento.",
                explanationEn = "Reframing technique for security and CISO objections using empathy followed by architectural proof (BYOK).",
                explanationEs = "Técnica consultiva para resolver objeciones del CISO: valida su preocupación y demuestra control total mediante llaves propias.",
                exampleEn = "I completely understand your security concerns; let me demonstrate how our customer-managed keys ensure GDPR and HIPAA compliance.",
                exampleEs = "Entiendo perfectamente su inquietud de seguridad; permítame mostrarle cómo las llaves gestionadas por ustedes garantizan el cumplimiento.",
                category = Categories.B2B_SALES,
                subcategory = Subcategories.SENTENCE
            )
        )
        list.add(
            Flashcard(
                termEn = "Let's align on the three key success metrics for a 2-week technical Proof of Concept (PoC).",
                meaningEs = "Alineemos las tres métricas clave de éxito para una Prueba de Concepto (PoC) técnica de dos semanas.",
                explanationEn = "Closing agreement that prevents endless, open-ended pilots and establishes objective criteria for purchase sign-off.",
                explanationEs = "Cierre consultivo indispensable: define previamente qué debe cumplirse para que la PoC se convierta en contrato comercial.",
                exampleEn = "Before we provision the environment, let's align on the three key success metrics for the 2-week PoC.",
                exampleEs = "Antes de provisionar el entorno, acordemos las tres métricas clave de éxito para la PoC de 2 semanas.",
                category = Categories.B2B_SALES,
                subcategory = Subcategories.SENTENCE
            )
        )
        list.add(
            Flashcard(
                termEn = "Who else on the engineering or procurement side should we include before the next architecture review?",
                meaningEs = "¿A quién más de ingeniería o compras deberíamos incluir antes de la próxima sesión técnica?",
                explanationEn = "Stakeholder mapping question to identify hidden decision-makers, blockers, and purchasing gatekeepers early.",
                explanationEs = "Pregunta de mapeo de decisores (MEDDPIC) para evitar sorpresas de última hora con el departamento legal o de compras.",
                exampleEn = "To keep momentum, who else on the engineering or procurement side should we include before the next architecture review?",
                exampleEs = "Para mantener el ritmo, ¿a quién más de ingeniería o compras deberíamos involucrar antes de la revisión técnica?",
                category = Categories.B2B_SALES,
                subcategory = Subcategories.SENTENCE
            )
        )
        list.add(
            Flashcard(
                termEn = "From a Total Cost of Ownership (TCO) perspective, this managed service reduces DevOps overhead by 35%.",
                meaningEs = "Desde la perspectiva de Costo Total de Propiedad (TCO), este servicio gestionado reduce la carga operativa de DevOps un 35%.",
                explanationEn = "Financial justification argument shifting the conversation from pure software license price to overall engineering cost savings.",
                explanationEs = "Argumento financiero que demuestra que el costo del software se compensa con creces liberando horas de ingenieros de alto valor.",
                exampleEn = "From a TCO perspective, adopting our serverless layer reduces DevOps infrastructure maintenance overhead by 35%.",
                exampleEs = "Desde una perspectiva de TCO, adoptar nuestra capa sin servidor reduce los costos de mantenimiento de DevOps un 35%.",
                category = Categories.B2B_SALES,
                subcategory = Subcategories.SENTENCE
            )
        )
        list.add(
            Flashcard(
                termEn = "Many enterprise clients had that initial hesitation before they validated our SOC 2 Type II certification.",
                meaningEs = "Muchos clientes corporativos tuvieron esa duda inicial antes de validar nuestra certificación SOC 2 Tipo II.",
                explanationEn = "Social proof objection handling ('Feel - Felt - Found' model) assuring the buyer of enterprise readiness.",
                explanationEs = "Manejo de objeciones con prueba social: valida que es natural tener esa duda y que empresas similares ya la comprobaron con éxito.",
                exampleEn = "Many Fortune 500 clients had that initial hesitation before they validated our SOC 2 Type II and ISO 27001 certifications.",
                exampleEs = "Muchos clientes corporativos tuvieron esa duda inicial antes de validar nuestras certificaciones SOC 2 e ISO 27001.",
                category = Categories.B2B_SALES,
                subcategory = Subcategories.SENTENCE
            )
        )

        return list
    }
}
