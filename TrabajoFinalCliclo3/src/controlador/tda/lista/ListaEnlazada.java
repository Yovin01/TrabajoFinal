/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.tda.lista;

import controlador.tda.lista.exception.PosicionException;

import controlador.utiles.Utilidades;

import controlador.utiles.TipoOrdenacion;
import static controlador.utiles.Utilidades.getMethod;
import static controlador.utiles.Utilidades.transformarDatoNumber;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;




public class ListaEnlazada<E> {

    private NodoLista<E> cabecera;

    private Integer size;
    private E matriz[];

    public NodoLista<E> getCabecera() {
        return cabecera;
    }

    public void setCabecera(NodoLista<E> cabecera) {
        this.cabecera = cabecera;
    }

    /**
     * Constructor de la clase se inicializa la lista en null y el tamanio en 0
     */
    public ListaEnlazada() {
        cabecera = null;
        size = 0;
    }

    /**
     * Permite ver si la lista esta vacia
     *
     * @return Boolean true si esta vacia, false si esta llena
     */
    public Boolean estaVacia() {
        return cabecera == null;
    }

    private void insertar(E dato) {
        NodoLista<E> nuevo = new NodoLista<>(dato, null);
        if (estaVacia()) {
            cabecera = nuevo;
        } else {
            NodoLista<E> aux = cabecera;
            while (aux.getSiguiente() != null) {
                aux = aux.getSiguiente();
            }
            aux.setSiguiente(nuevo);
        }
        size++;
    }

    public void insertarCabecera(E dato) {
        if (estaVacia()) {
            insertar(dato);
        } else {
            NodoLista<E> nuevo = new NodoLista<>(dato, null);

            nuevo.setSiguiente(cabecera);
            cabecera = nuevo;
            size++;
        }
    }

    public void insertar(E dato, Integer pos) throws PosicionException {
        //lista size = 1
        if (estaVacia()) {
            insertar(dato);
        } else if (pos >= 0 && pos < size) {
            NodoLista<E> nuevo = new NodoLista<>(dato, null);
            if (pos == (size - 1)) {
                insertar(dato);

            } else {

                NodoLista<E> aux = cabecera;
                for (int i = 0; i < pos - 1; i++) {
                    aux = aux.getSiguiente();
                }
                NodoLista<E> siguiente = aux.getSiguiente();
                aux.setSiguiente(nuevo);
                nuevo.setSiguiente(siguiente);
                size++;
            }

        } else {
            throw new PosicionException("Error en insertar: No existe la posicion dada");
        }
    }

    public void imprimir() {
        System.out.println("**************************");
        NodoLista<E> aux = cabecera;
        for (int i = 0; i < getSize(); i++) {
            System.out.print(aux.getDato().toString() + "\t");
            aux = aux.getSiguiente();
        }
        System.out.println("\n" + "**************************");
    }

    public Integer getSize() {
        return size;
    }

    /**
     * Metodo que permite obtener un dato segun la posicion
     *
     * @param pos posicion en la lista
     * @return Elemento
     */
    public E obtenerDato(Integer pos) throws PosicionException {
        if (!estaVacia()) {
            if (pos >= 0 && pos < size) {
                E dato = null;
                if (pos == 0) {
                    dato = cabecera.getDato();
                } else {
                    NodoLista<E> aux = cabecera;
                    for (int i = 0; i < pos; i++) {
                        aux = aux.getSiguiente();
                    }
                    dato = aux.getDato();
                }

                return dato;
            } else {
                throw new PosicionException("Error en obtener dato: No existe la posicion dada");
            }

        } else {
            throw new PosicionException("Error en obtener dato: La lista esta vacia, por endde no hay esa posicion");
        }
    }

    public E eliminarDato(Integer pos) throws PosicionException {
        E auxDato = null;
        if (!estaVacia()) {
            if (pos >= 0 && pos < size) {
                if (pos == 0) {
                    auxDato = cabecera.getDato();
                    cabecera = cabecera.getSiguiente();
                    size--;
                } else {
                    NodoLista<E> aux = cabecera;
                    for (int i = 0; i < pos - 1; i++) {
                        aux = aux.getSiguiente();
                    }
                    auxDato = aux.getDato();
                    NodoLista<E> proximo = aux.getSiguiente();
                    aux.setSiguiente(proximo.getSiguiente());
                    size--;
                }
                return auxDato;

            } else {
                throw new PosicionException("Error en eliminar dato: No existe la posicion dada");
            }

        } else {
            throw new PosicionException("Error en eliminar dato: La lista esta vacia, por endde no hay esa posicion");
        }
    }

    public void vaciar() {
        cabecera = null;
        size = 0;
        //en c utilizamos el free
        //malloc
    }

    public void modificarDato(Integer pos, E datoM) throws PosicionException {
        if (!estaVacia()) {
            if (pos >= 0 && pos < size) {
                // E dato = null;
                if (pos == 0) {
                    cabecera.setDato(datoM);
                } else {
                    NodoLista<E> aux = cabecera;
                    for (int i = 0; i < pos; i++) {
                        aux = aux.getSiguiente();
                    }
                    aux.setDato(datoM);
                }

            } else {
                throw new PosicionException("Error en obtener dato: No existe la posicion dada");
            }

        } else {
            throw new PosicionException("Error en obtener dato: La lista esta vacia, por endde no hay esa posicion");
        }
    }

    public E[] toArray() {
        E[] matriz = (E[]) (new Object[this.size]);
        NodoLista<E> aux = cabecera;
        for (int i = 0; i < this.size; i++) {
            matriz[i] = aux.getDato();
//         System.out.print(aux.getDato().toString() + "\t");
            aux = aux.getSiguiente();
        }
        return matriz;
    }

    public ListaEnlazada<E> toList(E[] matriz) {
        //E[] matriz = (E[]) (new Object[this.size]);
        this.vaciar();
        for (E matriz1 : matriz) {
            this.insertar(matriz1);
        }
        return this;
    }

//    public ListaEnlazada<E> ordenar_seleccion_burbuja(String atributo, TipoOrdenacion tipoOrdenacion) throws Exception {
//        Class<E> clazz = null;
//        E[] matriz = null;
//        if (size > 0) {
//            matriz = toArray();
//            E t = null;
//            clazz = (Class<E>) cabecera.getDato().getClass();//primitivo, Dato envolvente, Object
//            Boolean isObject = Utilidades.isObject(clazz);//si es objeto
//            Integer i, j, k = 0;
//            Integer n = matriz.length;
//            Integer cont = 0;
//            Metodos metodos = new Metodos();
//            for (i = 0; i < n - 1; i++) {
//                k = i;
//                t = matriz[i];
//                for (j = i + 1; j < n; j++) {
//                    if (isObject) {
//                        Field field = Utilidades.getField(atributo, clazz);
//                        Method method = getMethod("get" + Utilidades.capitalizar(atributo), t.getClass());
//                        Method method1 = getMethod("get" + Utilidades.capitalizar(atributo), matriz[j].getClass());
//
//                        //llamar a utilidades
//                        //if (field.getType().getSuperclass().getSimpleName().equalsIgnoreCase("Number")) {
//                        Object[] aux = metodos.evaluaCambiarDato(field.getType(), t, matriz[j], method, method1, tipoOrdenacion, j, matriz);
//                        // Object[] aux = evaluaCambiarDato(field.getType(), t, matriz[j], method, method1, tipoOrdenacion, j, matriz);
//                        if (aux[0] != null) {
//                            t = (E) aux[0];
//                            k = (Integer) aux[1];
//                            matriz[k] = matriz[i];
//                            matriz[i] = t;
//                            break;
//                        }
//                    } else {
//                        Object[] aux = metodos.evaluaCambiarDatoNoObjeto(clazz, t, matriz[j], tipoOrdenacion, j, matriz);
//                        //Object[] aux = evaluaCambiarDatoNoObjeto(clazz, t, matriz[j], tipoOrdenacion, j, matriz);
//                        if (aux[0] != null) {
//                            t = (E) aux[0];
//                            k = (Integer) aux[1];
//                            matriz[k] = matriz[i];
//                            matriz[i] = t;
//                            break;
//                        }
//                    }
//
//                }
//                //  matriz[k] = matriz[i];//intercambias cuando encountra el valor
//                //     matriz[i] = t;
//            }
//        }
//        if (matriz != null) {
//            toList(matriz);
//        }
//        return this;
//    }
//
//    public ListaEnlazada<E> ordenar_seleccion_sell(String atributo, TipoOrdenacion tipoOrdenacion) throws Exception {
//        Class<E> clazz = null;
//        E[] matriz = null;
//        Metodos metodos = new Metodos();
//        if (size > 0) {
//            matriz = toArray();
//            E t = null;
//            clazz = (Class<E>) cabecera.getDato().getClass();//primitivo, Dato envolvente, Object
//            Boolean isObject = Utilidades.isObject(clazz);//si es objeto
//            Integer n = matriz.length;
//            Integer salto = n;
//            Integer cont = 0;
//            boolean ordenado;
//            while (salto > 1) {
//                salto = salto / 2;
//                do {
//                    ordenado = true;
//                    for (int j = 0; j <= n - 1 - salto; j++) {
//                        t = matriz[j];
//                        int k = j + salto;
//                        if (isObject) {
//                            Field field = Utilidades.getField(atributo, clazz);
//                            Method method = getMethod("get" + Utilidades.capitalizar(atributo), t.getClass());
//                            Method method1 = getMethod("get" + Utilidades.capitalizar(atributo), matriz[k].getClass());
//
//                            //llamar a utilidades
//                            //if (field.getType().getSuperclass().getSimpleName().equalsIgnoreCase("Number")) {
//                            Object[] aux = metodos.evaluaCambiarDatoSell(field.getType(), t, matriz[k], method, method1, tipoOrdenacion, k, matriz);
//                            if (aux[0] != null) {
//                                t = (E) aux[0];
//                                k = (Integer) aux[1];
//                                matriz[k] = matriz[j];
//                                matriz[j] = t;
//                                ordenado = (boolean) aux[2];
//                            }
//                        } else {
//                            Object[] aux = metodos.evaluaCambiarDatoNoObjetoSell(clazz, t, matriz[k], tipoOrdenacion, k, matriz);
//                            if (aux[0] != null) {
//                                t = (E) aux[0];
//                                k = (Integer) aux[1];
//                                matriz[k] = matriz[j];
//                                matriz[j] = t;
//                                ordenado = (boolean) aux[2];
//                            }
//
//                        }
//
//                    }
//                } while (!ordenado);
//
//            }
//        }
//        if (matriz != null) {
//            toList(matriz);
//        }
//        return this;
//    }
//
//    private int particion(Class clazz, E[] arreglo, int izquierda, int derecha, String atributo) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
//        //  System.out.println("pB");
//        E pivote = arreglo[izquierda];
//        Boolean isObject = Utilidades.isObject(clazz);//si es objeto
//        if (isObject) {
//            while (true) {
//                Field field = Utilidades.getField(atributo, clazz);
//                Method method = getMethod("get" + Utilidades.capitalizar(atributo), arreglo[izquierda].getClass());
//                Method method1 = getMethod("get" + Utilidades.capitalizar(atributo), arreglo[derecha].getClass());
//                Method methodPivo = getMethod("get" + Utilidades.capitalizar(atributo), pivote.getClass());
//
//                //    System.out.println("Gto");
//                if (field.getType().getSuperclass().getSimpleName().equalsIgnoreCase("Number")) {
//                    //System.out.println("Number");
//                    while (((Number) method.invoke(arreglo[izquierda])).doubleValue() < ((Number) methodPivo.invoke(pivote)).doubleValue()) {
//                        izquierda++;
//                    }
//                    while (((Number) method1.invoke(arreglo[derecha])).doubleValue() > ((Number) methodPivo.invoke(pivote)).doubleValue()) {
//                        derecha--;
//                    }
//                    if (izquierda >= derecha) {
//
//                        return derecha;
//                    } else {
//                        E temporal = arreglo[izquierda];
//                        arreglo[izquierda] = arreglo[derecha];
//                        arreglo[derecha] = temporal;
//                        izquierda++;
//                        derecha--;
//                    }
//
//                } else if (Utilidades.isString(field.getType())) {
//                    //          System.out.println("String");
//
//                    while ((String.valueOf(method.invoke(arreglo[izquierda])).toLowerCase().compareTo(String.valueOf(methodPivo.invoke(pivote)).toLowerCase()) < 0)) {
//                        izquierda++;
//                    }
//                    while ((String.valueOf(method1.invoke(arreglo[derecha])).toLowerCase().compareTo(String.valueOf(methodPivo.invoke(pivote)).toLowerCase()) > 0)) {
//                        derecha--;
//                    }
//                    if (izquierda >= derecha) {
//
//                        return derecha;
//                    } else {
//                        E temporal = arreglo[izquierda];
//                        arreglo[izquierda] = arreglo[derecha];
//                        arreglo[derecha] = temporal;
//                        izquierda++;
//                        derecha--;
//                    }
//                }
//            }
//        } else {
//            while (true) {
//                if (clazz.getSuperclass().getSimpleName().equalsIgnoreCase("Number")) {
//
//                    while ((((Number) arreglo[izquierda]).doubleValue() < ((Number) pivote).doubleValue())) {
//                        izquierda++;
//                    }
//                    while ((((Number) arreglo[derecha]).doubleValue() > ((Number) pivote).doubleValue())) {
//                        derecha--;
//                    }
//                    if (izquierda >= derecha) {
//                        return derecha;
//                    } else {
//                        E temporal = arreglo[izquierda];
//                        arreglo[izquierda] = arreglo[derecha];
//                        arreglo[derecha] = temporal;
//                        izquierda++;
//                        derecha--;
//                    }
//
//                } else if (Utilidades.isString(clazz)) {
//
//                    String datoIzq = (String) arreglo[izquierda];
//                    String datoDer = (String) arreglo[derecha];
//                    String datoPivo = (String) pivote;
//                    while ((datoDer.toLowerCase().compareTo(datoPivo.toLowerCase()) > 0)) {
//                        derecha--;
//                    }
//                    while ((datoIzq.toLowerCase().compareTo(datoPivo.toLowerCase()) < 0)) {
//                        izquierda++;
//                    }
//                    if (izquierda >= derecha) {
//                        return derecha;
//                    } else {
//                        E temporal = arreglo[izquierda];
//                        arreglo[izquierda] = arreglo[derecha];
//                        arreglo[derecha] = temporal;
//                        izquierda++;
//                        derecha--;
//                    }
//                }
//            }
//
//        }
//
//    }
//
//    private void quickSort(String atributo, E[] matriz, int izq, int der, boolean comprobar) throws InvocationTargetException, IllegalAccessException {
//        //   System.out.println("dae");
//        E pivote = matriz[izq];
//        int i = izq;
//        int j = der;
//        E aux;
//        Class<E> clazz = null;
//        clazz = (Class<E>) cabecera.getDato().getClass();//primitivo, Dato envolvente, Object
//        Boolean isObject = Utilidades.isObject(clazz);//si es objeto
//
//        if (isObject) {
//            while (i < j) {
//
//                Field field = Utilidades.getField(atributo, clazz);
//                Method method = getMethod("get" + Utilidades.capitalizar(atributo), matriz[i].getClass());
//                Method method1 = getMethod("get" + Utilidades.capitalizar(atributo), matriz[j].getClass());
//                Method methodPivo = getMethod("get" + Utilidades.capitalizar(atributo), pivote.getClass());
//
//                //   System.out.println("Gto");
//                if (field.getType().getSuperclass().getSimpleName().equalsIgnoreCase("Number")) {
//
//                    while ((((Number) method.invoke(matriz[i])).doubleValue() <= ((Number) methodPivo.invoke(pivote)).doubleValue()) && i < j) {
//                        i++;
//                    }
//
//                    while ((((Number) method1.invoke(matriz[j])).doubleValue() > ((Number) methodPivo.invoke(pivote)).doubleValue())) {
//                        j--;
//                    }
//
//                } else if (Utilidades.isString(field.getType())) {
//                    while ((((String) method.invoke(matriz[i])).toLowerCase().compareTo(((String) methodPivo.invoke(pivote)).toLowerCase()) <= 0 && i < j)) {
//                        i++;
//                    }
//                    while ((((String) methodPivo.invoke(matriz[j])).toLowerCase().compareTo(((String) methodPivo.invoke(pivote)).toLowerCase()) > 0)) {
//                        j--;
//                    }
//
//                }
//                if (i < j) {
//                    aux = matriz[i];
//                    matriz[i] = matriz[j];
//                    matriz[j] = aux;
//                }
//            }
//        } else {
//            //      System.out.println("No object");
//            while (i < j) {
//                //    clazz = (Class<E>) cabecera.getDato().getClass();//primitivo, Dato envolvente, Object
//
//                //   System.out.println("Gto");
//                if (clazz.getSuperclass().getSimpleName().equalsIgnoreCase("Number")) {
//
//                    while ((((Number) matriz[i]).doubleValue() <= ((Number) pivote).doubleValue()) && i < j) {
//                        i++;
//                    }
//
//                    while ((((Number) matriz[j]).doubleValue() > ((Number) pivote).doubleValue())) {
//                        j--;
//                    }
//
//                } else if (Utilidades.isString(clazz)) {
//
//                    String datoIzq = ((String) matriz[i]);
//                    String datoDer = ((String) matriz[j]);
//                    String datoPivo = ((String) pivote);
//                    while ((datoIzq.toLowerCase().compareTo(datoPivo.toLowerCase()) <= 0 && i < j)) {
//                        i++;
//                    }
//                    while ((datoDer.toLowerCase().compareTo(datoPivo.toLowerCase()) > 0)) {
//                        j--;
//                    }
//
//                }
//                if (i < j) {
//                    aux = matriz[i];
//                    matriz[i] = matriz[j];
//                    matriz[j] = aux;
//                }
//            }
//        }
//
//        matriz[izq] = matriz[j];
//        matriz[j] = pivote;
//        if (izq < j - 1) {
//            quickSort(atributo, matriz, izq, j - 1, false);
//        }
//        if (j + 1 < der) {
//            quickSort(atributo, matriz, j + 1, der, false);
//        }
//        if (matriz != null && comprobar) {
//            toList(matriz);
//        }
//        //     System.out.println("dasd");
//
//    }
//
//    private void llamadaQuickSort(String atributo, E[] matriz, int izq, int der, boolean comprobar) {
//        //      System.out.println("dasd");
//        Class<E> clazz = null;
//        if (izq < der) {
//            try {
//                clazz = (Class<E>) cabecera.getDato().getClass();//primitivo, Dato envolvente, Object
//                int indiceParticion = particion(clazz, matriz, izq, der, atributo);
//                llamadaQuickSort(atributo, matriz, izq, indiceParticion, false);
//                llamadaQuickSort(atributo, matriz, indiceParticion + 1, der, false);
//            } catch (IllegalArgumentException ex) {
//                ex.printStackTrace();
//            } catch (IllegalAccessException | InvocationTargetException ex) {
//                Logger.getLogger(ListaEnlazada.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }
//        if (comprobar) {
//            toList(matriz);
//        }
//    }
//
//    public void quickSortCPart(String atributo, TipoOrdenacion tipoOrdenacion) {
//        E[] matriz = toArray();
//        llamadaQuickSort(atributo, matriz, 0, matriz.length - 1, true);
//        rotar(tipoOrdenacion);
//    }
//
//    public void quickSort(String atributo, TipoOrdenacion tipoOrdenacion) {
//        try {
//            quickSort("nombre", toArray(), 0, toArray().length - 1, true);
//            rotar(tipoOrdenacion);
//        } catch (InvocationTargetException | IllegalAccessException ex) {
//            Logger.getLogger(ListaEnlazada.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
//
//    public void rotar(TipoOrdenacion tipoOrdenacion) {
//        if (tipoOrdenacion.toString().equalsIgnoreCase(TipoOrdenacion.DESCENDENTE.toString())) {
//            E matriz1[] = toArray();
//            E[] matriz2 = toArray();
//            int size = matriz1.length - 1;
//
//            for (int i = 0, j = matriz1.length - 1; i < matriz1.length; i++, j--) {
//                matriz2[i] = matriz1[j];
//            }
//            toList(matriz2);
//        }
//    }
//
//    /*
//     public ListaEnlazada<E> burbuja(String atributo, TipoOrdenacion tipoOrdenacion) throws PosicionException, Exception {
//     Class<E> clazz = null;
//     E[] matriz = null;
//     if (size > 0) {
//     clazz = (Class<E>) cabecera.getDato().getClass();//primitivo, Dato envolvente, Object
//     Boolean isObject = Utilidades.isObject(clazz);//si es objeto
//     System.out.println("TRANFORMANDO A MATRIZ");
//     matriz = toArray();
//     if (isObject) {
//     for (int i = matriz.length; i > 1; i--) {
//     for (int j = 0; j < i - 1; j++) {
//     //E auxJ = this.obtenerDato(j);
//     //E auxJ1 = this.obtenerDato(j + 1);//getApellido
//     E auxJ = matriz[j];
//     E auxJ1 = matriz[j + 1];//getApellido
//     Field field = Utilidades.getField(atributo, clazz);
//     Method method = getMethod("get" + Utilidades.capitalizar(atributo), auxJ.getClass());
//     Method method1 = getMethod("get" + Utilidades.capitalizar(atributo), auxJ1.getClass());
//     //llamar a utilidades
//     //if (field.getType().getSuperclass().getSimpleName().equalsIgnoreCase("Number")) {
//     evaluaCambiarDato(field.getType(), auxJ, auxJ1, method, method1, tipoOrdenacion, j, matriz);
//
//     }
//     }
//     } else {
//     System.out.println("METODO BURBUJA");
//     for (int i = matriz.length; i > 1; i--) {
//     for (int j = 0; j < i - 1; j++) {
//     //E auxJ = this.obtenerDato(j);
//     //E auxJ1 = this.obtenerDato(j + 1);//getApellido
//     E auxJ = matriz[j];
//     E auxJ1 = matriz[j + 1];
//     evaluaCambiarDatoNoObjeto(clazz, auxJ, auxJ1, tipoOrdenacion, j, matriz);
//     }
//     }
//     }
//
//     }
//     System.out.println("TRANFORMANDO A LISTA");
//     if (matriz != null) {
//     toList(matriz);
//     }
//     return this;
//     }
//     */
//    private ListaEnlazada<E> buscar(String atributo, E valor) throws Exception {
//        E[] arreglo = toArray();
//        boolean encontrado = false;
//        Metodos metodos = new Metodos();
//        ListaEnlazada listaBusqueda = new ListaEnlazada();
//        int inicio = 0;
//        int fin = size - 1;
//        Class<E> clazz = null;
//        clazz = (Class<E>) cabecera.getDato().getClass();//primitivo, Dato envolvente, Object
//        Boolean isObject = Utilidades.isObject(clazz);//si es objeto
//        while (inicio <= fin && !encontrado) {
//            int medio = (inicio + fin) / 2;
//            if (isObject) {
//                Field field = Utilidades.getField(atributo, clazz);
//                Method method = getMethod("get" + Utilidades.capitalizar(atributo), arreglo[medio].getClass());
//                if (metodos.isIgualObject(field.getType(), arreglo[medio], valor, method)) { // es igual a valo
//                    encontrado = true;
//                    if (medio >= 0) {
//                        int medioPosMenor = medio;
//                        //       System.out.println("de");
//                        while (metodos.isIgualObject(field.getType(), arreglo[medioPosMenor], valor, method)) {
//                            listaBusqueda.insertar(arreglo[medioPosMenor]);
//                            if (medioPosMenor > 0) {
//                                medioPosMenor--;
//                            } else {
//                                break;
//                            }
//                        }
//                    }
//                    if (medio <= size - 1) {
//                        if (medio == size - 1) {
//                            //    int medioPosMayor = medio + 1;
//                        } else {
//                            int medioPosMayor = medio + 1;
//                            while (metodos.isIgualObject(field.getType(), arreglo[medioPosMayor], valor, method)) {
//                                listaBusqueda.insertar(arreglo[medioPosMayor]);
//                                if (medioPosMayor < size - 1) {
//                                    medioPosMayor++;
//                                } else {
//                                    break;
//                                }
//                            }
//                        }
//                    }
//                } else {
//                    if (metodos.isMayorObject(field.getType(), arreglo[medio], valor, method)) {
//                        fin = medio - 1;
//                    } else {
//                        inicio = medio + 1;
//                    }
//                }
//            } else {
//
//                if (metodos.isIgualNoObject(clazz, arreglo[medio], valor)) { // es igual a valo
//                    encontrado = true;
//                     listaBusqueda.insertar(arreglo[medio]);
//                    if (medio >= 0) {
//                        int medioPosMenor = medio-1;
//                        while (metodos.isIgualNoObject(clazz, arreglo[medioPosMenor], valor)) {
//                            listaBusqueda.insertar(arreglo[medioPosMenor]);
//                            medioPosMenor--;
//                        }
//                    }
//                    if (medio <= size - 1) {
//                        if (medio == size - 1) {
//                            //    int medioPosMayor = medio + 1;
//                        } else {
//                            int medioPosMayor = medio + 1;
//                            while (metodos.isIgualNoObject(clazz, arreglo[medioPosMayor], valor)) {
//                                listaBusqueda.insertar(arreglo[medioPosMayor]);
//                                medioPosMayor++;
//                            }
//                        }
//                    }
//                } else {
//                    if (metodos.isMayorNoObject(clazz, arreglo[medio], valor)) {
//                        fin = medio - 1;
//                    } else {
//                        inicio = medio + 1;
//                    }
//                }
//            }
//        }
//        listaBusqueda.insertarCabecera(encontrado);
//        return listaBusqueda;
//    }
//
//    public DefaultTableModel tablaBusqueda(String atributo, E valor, String ordenacion) throws Exception {
//        if (ordenacion.equalsIgnoreCase("shell")) {
//            ordenar_seleccion_sell(atributo, TipoOrdenacion.ASCENDENTE);
//        } else {
//            quickSortCPart(atributo, TipoOrdenacion.ASCENDENTE);
//        }
////         Class<E> clazz = null;
////        clazz = (Class<E>) cabecera.getDato().getClass();
////        Field field = Utilidades.getField(atributo, clazz);
////        Method method = getMethod("get" + Utilidades.capitalizar(atributo), arreglo[medio].getClass());
//     ListaEnlazada lista = buscar(atributo, valor);
//        DefaultTableModel model = new DefaultTableModel();
//        model.addColumn("Nombre");
//        model.addColumn("Apellido");
//        model.addColumn("Cedula");
//        String datos[] = new String[3];
////        E dao = lista.getCabecera();
//        if ((boolean) lista.getCabecera().getDato()) {
//            for (int i = 1; i < lista.getSize(); i++) {
//                Persona p = (Persona) lista.obtenerDato(i);
//                datos[0] = p.getNombre();
//                datos[1] = p.getApellido();
//                datos[2] = String.valueOf(p.getCedula());
//                model.addRow(datos);
//            }
//        }else{
//          JOptionPane.showMessageDialog(null, "No existe el "+atributo);
//        }
//        return model;
//    }
//
//    public static void main(String[] args) throws Exception {
//        //ListaEnlazada lista = new ListaEnlazada();
//        //       ListaEnlazada <String>lista = new ListaEnlazada<>();
//        ListaEnlazada listaBus = new ListaEnlazada();
//        ListaEnlazada<Persona> lista = new ListaEnlazada<>();
////            FileReader fr = new FileReader("datos" + File.separatorChar + "numero.txt");
////            BufferedReader entrada = new BufferedReader(fr);
////            String aux = entrada.readLine();
////            Integer cont = 0;
////            while (aux != null) {
////                //matriz[cont] = Integer.parseInt(aux);
////                //lista.insertar(aux);
////                aux = entrada.readLine();
////                cont++;
////            }
////            fr.close();
////            entrada.close();
//
////        Persona n1 = new Persona("j", "k", 1);
////        Persona n2 = new Persona("a", "p", 4);
////        Persona n3 = new Persona("z", "t", 10);
////        Persona n4 = new Persona("a", "o", 3);
////        Persona n5 = new Persona("c", "htr", 3);
////        Persona n6 = new Persona("a", "ert", 3);
////        Persona n7 = new Persona("u", "gty", 3);
////        lista.insertarCabecera(1);
////        lista.insertarCabecera(4);
////        lista.insertarCabecera(2);
////        lista.insertarCabecera(6);
////        lista.insertarCabecera(n1);
////        lista.insertarCabecera(n2);
////        lista.insertarCabecera(n3);
////        lista.insertarCabecera(n4);
////        lista.insertarCabecera(n5);
////        lista.insertarCabecera(n6);
////        lista.insertarCabecera(n7);
////        lista.insertarCabecera("dasd");
////        lista.insertarCabecera("asdw");
////        lista.insertarCabecera("wder");
////        lista.insertarCabecera("asdece");
//        lista.imprimir();
//        System.out.println("SELECCION");
//        //lista.matriz.length;
//
//        try {
//            //        lista.quickSort("cedula", TipoOrdenacion.DESCENDENTE);
//            // lista.ordenar_seleccion_sell("cedula", TipoOrdenacion.DESCENDENTE);
//            // lista.rotar(TipoOrdenacion.DESCENDENTE);
//            //    lista.quickSortCPart("cedula", TipoOrdenacion.ASCENDENTE);
//    //        listaBus = lista.buscar("nombre", "a", "shell");
////            System.out.println(lista.obtenerDato(0));//getCedula());
////            System.out.println(lista.obtenerDato(1));//getCedula());
////            System.out.println(lista.obtenerDato(2)); //getCedula());
////            System.out.println(lista.obtenerDato(3)); //getCedula());
////            System.out.println(lista.obtenerDato(0).getNombre());
////            System.out.println(lista.obtenerDato(1).getNombre());
////            System.out.println(lista.obtenerDato(2).getNombre());
////            System.out.println(lista.obtenerDato(3).getNombre());
////            System.out.println(lista.obtenerDato(0).getCedula());
////            System.out.println(lista.obtenerDato(1).getCedula());
////            System.out.println(lista.obtenerDato(2).getCedula());
////            System.out.println(lista.obtenerDato(3).getCedula());
//            for (int i = 1; i < listaBus.size; i++) {
//                Persona P = (Persona) listaBus.obtenerDato(i);
//                System.out.println(P.getApellido());
//            }
//        } catch (PosicionException e) {
//            System.out.println("eor " + e);
//        } catch (IllegalArgumentException ex) {
//            Logger.getLogger(ListaEnlazada.class.getName()).log(Level.SEVERE, null, ex);
//        }
//
//    }

}
