La cobertura de linea inicial es del 97%, y de rama es del 93%. No existe clase de test para las suscripciones, si bien en otros test estas se utilizan, lo cual puede poner en cuestión la unicidad de las pruebas. CORREGIDO.

Utiliza Error.class en vez de Extension.class. CORREGIDO.

Es necesario aplicarle explicitamente el IVA a los articulos de libreria cuando se los crea para que el precio sea el correcto. Esto ocurre porque considera la posibilidad de agregarle el IVA a todo producto, no únicamente para los artículos de librería. CORREGIDO.

Es necesario, cuando se crea una suscripción, setearle su precio con el resultado de un método que la misma clase suscripcion tiene, de forma que podría hacerse internamente sobrescribiendo el metodo setPrecio. CORREGIDO.

La librería y el cliente se encargan de "comprar" productos. La librería es quien intermedia con los clientes para indicarles lo que tienen que comprar. Le correspondería comprar exclusivamente al cliente. CORREGIDO.

El cálculo del precio de la suscripción le corresponde a los productos suscriptos (revista y periodico) y no a la suscripción. De hecho, la suscripción es siempre anual, no considera la posibilidad de suscribirse únicamente por un mes. CORREGIDO.

Permite incorporarle DNI a los clientes, pero no hace uso de esa característica para distinguirlos unívocamente. Si se encuentran dos clientes con igual nombre en la lista de clientes de la librería, los considerará el mismo cliente aunque tengan distinto DNI. CORREGIDO.

Cada mes es la implementacion de una compra del mes en el cliente, y distingue a los meses por su nombre. Puedo agregar varias compras del mismo mes, pero si ignoro el casing al nombrar los meses, por ejemplo "AGOSTO" y "agosto", no va a considerar que son compras del mismo mes. De hecho puedo incorporar meses que no existen en la realidad con solo definirles un nombre. CORREGIDO.

Originalmente, un cliente puede tener varias compras distintas asociadas al mismo mes, lo que implica que cuando se compra un producto en un mes, si hay varias compras correspondientes a ese mes el producto se agrega a todas ellas, y no solamente a una de las compras, afectando el cálculo del precio a cobrar en ese mes. CORREGIDO.

Existe la clase libro sin redefinir ningún comportamiento ni agregar atributos. La considero necesaria para distinguir entre los productos que son libros y el resto para poder alquilar exclusivamente los primeros.

Para el ejercicio se agregaron las clases Alquiler, que hereda de Producto, y AlquilerDiario, AlquilerMensual y AlquilerCuatrimestral que heredan de Alquiler. No fueron necesarias, para su creación, mayores consideraciones con el diseño. Se hicieron las correcciones previamente descriptas para que la aplicación se ajuste más a criterios comentados durante la cursada, por ejemplo la necesidad de que las pruebas sean correctas y cubran todo el código.


