# 🏢 Sistema de Ascensor Interactivo

## ✨ Características

Este es un simulador completo de ascensor que te permite:

- 📍 Ubicarte en cualquier piso del edificio
- 📞 Llamar al ascensor desde tu ubicación
- 🚶 Entrar y salir del ascensor
- 🎯 Seleccionar pisos de destino
- 👁️ Ver el estado del ascensor en tiempo real

## 🚀 Cómo ejecutar el programa

### Opción 1: Desde la terminal

1. **Compila todos los archivos:**

   ```bash
   javac *.java
   ```

2. **Ejecuta el programa:**
   ```bash
   java SistemaAscensorInteractivo
   ```

### Opción 2: Desde VS Code

1. Abre el archivo `SistemaAscensorInteractivo.java`
2. Haz clic derecho en el editor
3. Selecciona "Run Java"

## 🎮 Cómo usar el sistema

### Inicio

- El programa te preguntará cuántos pisos tiene el edificio
- Luego te preguntará en qué piso estás ubicado
- El ascensor empieza en el piso 1

### Menú principal

El menú cambia según dónde estés:

#### Si estás FUERA del ascensor:

1. **Llamar al ascensor** - Lo llama a tu piso
2. **Entrar al ascensor** - Solo si está en tu piso con la puerta abierta
3. **Seleccionar piso** - No disponible (debes estar dentro)
4. **Salir** - Cierra el programa

#### Si estás DENTRO del ascensor:

1. **Llamar al ascensor** - No disponible (ya estás dentro)
2. **Salir del ascensor** - Sales en el piso actual
3. **Seleccionar piso** - Eliges a qué piso ir
4. **Salir** - Cierra el programa

## 📋 Ejemplo de uso típico

1. **Iniciar**: Estás en el piso 3, ascensor está en piso 1
2. **Llamar ascensor**: Presionas botón para subir/bajar
3. **Esperar**: El ascensor se mueve a tu piso y abre la puerta
4. **Entrar**: Ingresas al ascensor
5. **Seleccionar destino**: Presionas el piso 7
6. **Viajar**: El ascensor cierra la puerta y se mueve al piso 7
7. **Salir**: Sales del ascensor en el piso 7

## 🎯 Validaciones del sistema

El programa verifica:

- ✅ No puedes entrar si el ascensor no está en tu piso
- ✅ No puedes entrar si la puerta está cerrada
- ✅ No puedes seleccionar piso si no estás dentro
- ✅ No puedes llamar para "subir" si estás en el último piso
- ✅ No puedes llamar para "bajar" si estás en el primer piso
- ✅ La puerta no se abre durante el movimiento

## 🏗️ Estructura del proyecto

- `Boton.java` - Clase base para botones
- `BotonPiso.java` - Botones externos (subir/bajar)
- `BotonCabina.java` - Botones internos del ascensor
- `Puerta.java` - Control de apertura/cierre
- `Ascensor.java` - La cabina del ascensor
- `ControlAscensor.java` - Sistema de control central
- `SistemaAscensorInteractivo.java` - Programa principal interactivo

## 🎨 Símbolos usados

- 🏢 Edificio
- 🛗 Ascensor
- 📍 Ubicación
- 📞 Llamar
- 🚶 Entrar/Salir
- 🎯 Destino
- 🚪 Puerta
- ⬆️ Subir
- ⬇️ Bajar
- ✅ Éxito
- ❌ Error
- 🟢 Abierto
- 🔴 Cerrado
