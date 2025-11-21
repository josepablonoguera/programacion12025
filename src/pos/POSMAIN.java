package pos;




import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Date; // para Date.valueOf("yyyy-MM-dd")
import java.util.ArrayList;
import java.util.List;

public class POSMAIN {

    // ====== Enums ======
    enum Puesto { CAJERO, ADMINISTRADOR, CONSERJE }
    enum Estado { ACTIVO, INACTIVO }

    // ====== Modelo base ======
    static abstract class Employee {
        private final String idEmpleado;
        private final Puesto puesto;
        private final String fechaEntrada;  // ISO "yyyy-MM-dd" (texto simple)
        private final String fechaSalida;   // ISO "yyyy-MM-dd" (texto simple)
        private final Estado estado;
        private final boolean disability;
        private final int heightCm;
        private final int weightKg;
        private final Date birthday;        // java.sql.Date
        private final String email;
        private final String idPersona;     // cédula
        private final String name;
        private final String phoneNumber;

        protected Employee(String idEmpleado, Puesto puesto, String fechaEntrada, String fechaSalida,
                           Estado estado, boolean disability, int heightCm, int weightKg, Date birthday,
                           String email, String idPersona, String name, String phoneNumber) {
            this.idEmpleado = idEmpleado;
            this.puesto = puesto;
            this.fechaEntrada = fechaEntrada;
            this.fechaSalida = fechaSalida;
            this.estado = estado;
            this.disability = disability;
            this.heightCm = heightCm;
            this.weightKg = weightKg;
            this.birthday = birthday;
            this.email = email;
            this.idPersona = idPersona;
            this.name = name;
            this.phoneNumber = phoneNumber;
        }

        public Puesto getPuesto() { return puesto; }

        @Override
        public String toString() {
            return "Empleado{" +
                    "idEmpleado='" + idEmpleado + '\'' +
                    ", puesto=" + puesto +
                    ", fechaEntrada='" + fechaEntrada + '\'' +
                    ", fechaSalida='" + fechaSalida + '\'' +
                    ", estado=" + estado +
                    ", disability=" + disability +
                    ", heightCm=" + heightCm +
                    ", weightKg=" + weightKg +
                    ", birthday=" + birthday +
                    ", email='" + email + '\'' +
                    ", idPersona='" + idPersona + '\'' +
                    ", name='" + name + '\'' +
                    ", phoneNumber='" + phoneNumber + '\'' +
                    '}';
        }
    }

    static class Cajero extends Employee {
        private final String idCajero;
        private final double cajaChica;

        public Cajero(String idCajero, double cajaChica,
                      String idEmpleado, Puesto puesto, String fechaEntrada, String fechaSalida,
                      Estado estado, boolean disability, int height, int weight, Date birthday,
                      String email, String idPersona, String name, String phoneNumber) {
            super(idEmpleado, puesto, fechaEntrada, fechaSalida, estado, disability, height, weight,
                    birthday, email, idPersona, name, phoneNumber);
            this.idCajero = idCajero;
            this.cajaChica = cajaChica;
        }

        @Override
        public String toString() {
            return "Cajero{" +
                    "idCajero='" + idCajero + '\'' +
                    ", cajaChica=" + cajaChica +
                    "} " + super.toString();
        }
    }

    static class Administrador extends Employee {
        private final String idAdmin;
        private final double bonus;

        public Administrador(String idAdmin, double bonus,
                             String idEmpleado, Puesto puesto, String fechaEntrada, String fechaSalida,
                             Estado estado, boolean disability, int height, int weight, Date birthday,
                             String email, String idPersona, String name, String phoneNumber) {
            super(idEmpleado, puesto, fechaEntrada, fechaSalida, estado, disability, height, weight,
                    birthday, email, idPersona, name, phoneNumber);
            this.idAdmin = idAdmin;
            this.bonus = bonus;
        }

        @Override
        public String toString() {
            return "Administrador{" +
                    "idAdmin='" + idAdmin + '\'' +
                    ", bonus=" + bonus +
                    "} " + super.toString();
        }
    }

    // Opcional simple para la opción 3 del menú
    static class Conserje extends Employee {
        private final String idConserje;
        private final String areaAsignada;

        public Conserje(String idConserje, String areaAsignada,
                        String idEmpleado, Puesto puesto, String fechaEntrada, String fechaSalida,
                        Estado estado, boolean disability, int height, int weight, Date birthday,
                        String email, String idPersona, String name, String phoneNumber) {
            super(idEmpleado, puesto, fechaEntrada, fechaSalida, estado, disability, height, weight,
                    birthday, email, idPersona, name, phoneNumber);
            this.idConserje = idConserje;
            this.areaAsignada = areaAsignada;
        }

        @Override
        public String toString() {
            return "Conserje{" +
                    "idConserje='" + idConserje + '\'' +
                    ", areaAsignada='" + areaAsignada + '\'' +
                    "} " + super.toString();
        }
    }

    // ====== Estado de la app ======
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static final List<Employee> planilla = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        menu();
    }

    private static void menu() throws IOException {
        int opc;
        do {
            System.out.println("\n=== MENÚ PLANILLA ===");
            System.out.println("1) Agregar Empleado");
            System.out.println("2) Mostrar Planilla");
            System.out.println("0) Salir");
            System.out.print("Seleccione una opción: ");
            String line = br.readLine();
            if (line == null || line.trim().isEmpty()) { opc = -1; continue; }
            try {
                opc = Integer.parseInt(line.trim());
            } catch (NumberFormatException e) {
                opc = -1;
            }

            switch (opc) {
                case 1:
                    Employee e = crearEmpleado();
                    if (e != null) {
                        planilla.add(e);
                        System.out.println(">> Empleado agregado. Total en planilla: " + planilla.size());
                    }
                    break;
                case 2:
                    mostrarPlanilla();
                    break;
                case 0:
                    System.out.println("Hasta luego!");
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        } while (opc != 0);
    }

    private static void mostrarPlanilla() {
        if (planilla.isEmpty()) {
            System.out.println("No hay empleados en planilla.");
            return;
        }

        for (Employee emp : planilla) {
            if (emp instanceof Cajero) {
                Cajero c1 = (Cajero) emp;
                System.out.println("\n--- Cajero ---");
                System.out.println(c1);
            } else if (emp instanceof Administrador) {
                Administrador a1 = (Administrador) emp;
                System.out.println("\n--- Administrador ---");
                System.out.println(a1);
            } else if (emp instanceof Conserje) {
                Conserje con = (Conserje) emp;
                System.out.println("\n--- Conserje ---");
                System.out.println(con);
            } else {
                System.out.println("\n--- Empleado ---");
                System.out.println(emp);
            }
        }
    }

    private static Employee crearEmpleado() throws IOException {
        System.out.println("\nMódulo de crear empleados");
        System.out.println("1. Cajero");
        System.out.println("2. Administrador");
        System.out.println("3. Conserje");
        System.out.println("4. Regresar");
        System.out.print("Opción: ");
        int opc = parseIntSafe(br.readLine(), -1);

        switch (opc) {
            case 1: // Cajero
                System.out.print("Ingrese el ID del Cajero: ");
                String idCajero = br.readLine();

                System.out.print("Ingrese el monto de Caja Chica: ");
                double cajaChica = parseDoubleSafe(br.readLine(), 0.0);

                CommonData cd1 = leerDatosComunes(Puesto.CAJERO);
                if (cd1 == null) return null;

                Cajero c1 = new Cajero(
                        idCajero, cajaChica,
                        cd1.idEmpleado, cd1.puesto, cd1.fechaEntrada, cd1.fechaSalida,
                        cd1.estado, cd1.disability, cd1.height, cd1.weight, cd1.birthday,
                        cd1.email, cd1.idPersona, cd1.name, cd1.phoneNumber
                );
                System.out.println("Cajero creado: " + c1);
                return c1;

            case 2: // Administrador
                System.out.print("Ingrese el ID del Administrador: ");
                String idAdmin = br.readLine();

                System.out.print("Ingrese el bono del Administrador: ");
                double bonus = parseDoubleSafe(br.readLine(), 0.0);

                CommonData cd2 = leerDatosComunes(Puesto.ADMINISTRADOR);
                if (cd2 == null) return null;

                Administrador a1 = new Administrador(
                        idAdmin, bonus,
                        cd2.idEmpleado, cd2.puesto, cd2.fechaEntrada, cd2.fechaSalida,
                        cd2.estado, cd2.disability, cd2.height, cd2.weight, cd2.birthday,
                        cd2.email, cd2.idPersona, cd2.name, cd2.phoneNumber
                );
                System.out.println("Administrador creado: " + a1);
                return a1;

            case 3: // Conserje
                System.out.print("Ingrese el ID del Conserje: ");
                String idCon = br.readLine();

                System.out.print("Área asignada: ");
                String area = br.readLine();

                CommonData cd3 = leerDatosComunes(Puesto.CONSERJE);
                if (cd3 == null) return null;

                Conserje con = new Conserje(
                        idCon, area,
                        cd3.idEmpleado, cd3.puesto, cd3.fechaEntrada, cd3.fechaSalida,
                        cd3.estado, cd3.disability, cd3.height, cd3.weight, cd3.birthday,
                        cd3.email, cd3.idPersona, cd3.name, cd3.phoneNumber
                );
                System.out.println("Conserje creado: " + con);
                return con;

            case 4:
                System.out.println("Regresando al menú...");
                return null;

            default:
                System.out.println("No ha seleccionado un puesto válido.");
                return null;
        }
    }

    // ====== Lectura de datos comunes a cualquier empleado ======
    private static class CommonData {
        String idEmpleado;
        Puesto puesto;
        String fechaEntrada;
        String fechaSalida;
        Estado estado;
        boolean disability;
        int height;
        int weight;
        Date birthday;
        String email;
        String idPersona;
        String name;
        String phoneNumber;
    }

    private static CommonData leerDatosComunes(Puesto puestoPorDefecto) throws IOException {
        CommonData cd = new CommonData();

        System.out.print("Ingrese el ID del Empleado: ");
        cd.idEmpleado = br.readLine();

        System.out.print("Ingrese el puesto (CAJERO, ADMINISTRADOR, CONSERJE) [Enter para " + puestoPorDefecto + "]: ");
        String puestoStr = br.readLine();
        cd.puesto = puestoStr == null || puestoStr.trim().isEmpty()
                ? puestoPorDefecto
                : parsePuesto(puestoStr);

        System.out.print("Ingrese la fecha de entrada (yyyy-MM-dd): ");
        cd.fechaEntrada = br.readLine();

        System.out.print("Ingrese la fecha de salida (yyyy-MM-dd): ");
        cd.fechaSalida = br.readLine();

        System.out.print("Ingrese el estado (ACTIVO, INACTIVO) [Enter=ACTIVO]: ");
        String estStr = br.readLine();
        cd.estado = estStr == null || estStr.trim().isEmpty()
                ? Estado.ACTIVO
                : parseEstado(estStr);

        System.out.print("¿Tiene discapacidad? (true/false): ");
        cd.disability = Boolean.parseBoolean(nullToEmpty(br.readLine()));

        System.out.print("Ingrese la altura (en cm): ");
        cd.height = parseIntSafe(br.readLine(), 0);

        System.out.print("Ingrese el peso (en kg): ");
        cd.weight = parseIntSafe(br.readLine(), 0);

        System.out.print("Ingrese la fecha de nacimiento (yyyy-MM-dd): ");
        cd.birthday = parseSqlDate(br.readLine());

        System.out.print("Ingrese el email: ");
        cd.email = br.readLine();

        System.out.print("Ingrese el ID (cédula): ");
        cd.idPersona = br.readLine();

        System.out.print("Ingrese el nombre: ");
        cd.name = br.readLine();

        System.out.print("Ingrese el número de teléfono: ");
        cd.phoneNumber = br.readLine();

        return cd;
    }

    // ====== Utilidades de parseo ======
    private static Puesto parsePuesto(String s) {
        if (s == null) return Puesto.CAJERO;
        s = s.trim().toUpperCase();
        try {
            return Puesto.valueOf(s);
        } catch (IllegalArgumentException ex) {
            System.out.println("Puesto inválido, usando CAJERO por defecto.");
            return Puesto.CAJERO;
        }
    }

    private static Estado parseEstado(String s) {
        if (s == null) return Estado.ACTIVO;
        s = s.trim().toUpperCase();
        try {
            return Estado.valueOf(s);
        } catch (IllegalArgumentException ex) {
            System.out.println("Estado inválido, usando ACTIVO por defecto.");
            return Estado.ACTIVO;
        }
    }

    private static int parseIntSafe(String s, int def) {
        try { return Integer.parseInt(s.trim()); } catch (Exception e) { return def; }
    }

    private static double parseDoubleSafe(String s, double def) {
        try { return Double.parseDouble(s.trim()); } catch (Exception e) { return def; }
    }

    private static String nullToEmpty(String s) { return s == null ? "" : s; }

    private static Date parseSqlDate(String s) {
        try { return Date.valueOf(s.trim()); } catch (Exception e) {
            System.out.println("Fecha inválida, usando 1970-01-01.");
            return Date.valueOf("1970-01-01");
        }
    }
}
