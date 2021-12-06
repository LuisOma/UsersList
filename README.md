# UsersList

Proyecto de demostración con Random User, basado en una arquitectura CLEAN con MVVM.

## Funciones de la aplicación

- Los usuarios pueden ver la lista de 20 usuario.
- Los usuarios pueden hacer clic en cualquier item para ver detalles de su elección.

## Arquitectura de la aplicación
Basado en la arquitectura Clean y el patrón de repositorio.

## La aplicación incluye los siguientes componentes principales:
- Un servicio de API web.
- Un repositorio que trabaja con el servicio api, proporcionando una interfaz de datos unificada.
- Un ViewModel que proporciona datos específicos para la interfaz de usuario.
- La interfaz de usuario, que muestra una representación visual de los datos en ViewModel.

## Paquetes de aplicaciones
- data.
- ui.
- domain.

## Especificaciones de la aplicación
- SDK mínimo: 21
- SDK target: 30
- Kotlin en la rama maestra
- Arquitectura MVVM
- Componentes de la arquitectura de Android (LiveData, ViewModel, componente de navegación, ConstraintLayout)
- **Retrofit 2** para integración API.
- **Gson** para serialización.
- **Picasso** para cargar imágenes.
