package learn.java;

import java.util.Scanner;

public class Main {
    private static Book[] library = new Book[100];
    private static int bookCount = 0;
    private static ActivityStack activities = new ActivityStack();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\n--- SYSTÈME DE GESTION DE BIBLIOTHÈQUE ---");
            System.out.println("1. Ajouter un livre\n2. Afficher les livres\n3. Trier par titre (Bulles)\n4. Rechercher (Binaire)\n5. Historique d'activités\n6. Quitter");
            System.out.print("Choix : ");
            int choice = sc.nextInt();
            sc.nextLine(); 

            switch (choice) {
                case 1:
                    System.out.println("\n--- AJOUTER UN LIVRE ---");
                    System.out.print("entrer le Titre du livre: "); String t = sc.nextLine();
                    System.out.print("entrer nom de l'Auteur : "); String a = sc.nextLine();
                    System.out.print("entrer l'ISBN du livre: "); String i = sc.nextLine();
                    System.out.print("entrer l'Année de publication: "); int y = sc.nextInt();
                    library[bookCount++] = new Book(t, a, i, y, "Général");
                    activities.push("Ajout du livre : " + t);
                    break;
                case 2:
                    System.out.println("\n--- LISTES DES LIVRES ---");
                    for(int k=0; k<bookCount; k++) System.out.println(library[k]);
                    break;
                case 3:
                    System.out.println("\n--- TRIER PAR TITRE ---");
                    LibraryManager.bubbleSort(library, bookCount);
                    activities.push("Tri de la bibliothèque effectué.");
                    System.out.println("Tri terminé.");
                    break;
                case 4:
                    System.out.println("\n--- RECHERCHE UN LIVRE ---");
                    System.out.print("Titre à rechercher : ");
                    String searchT = sc.nextLine();
                    int idx = LibraryManager.binarySearch(library, bookCount, searchT);
                    if(idx != -1) System.out.println("Trouvé : " + library[idx]);
                    else System.out.println("Non trouvé.");
                    activities.push("Recherche de : " + searchT);
                    break;
                case 5:
                    System.out.println("\n--- HISTORIQUE DE LIVRES ---");
                    System.out.println("Activités : " + activities.getAll());
                    break;
                case 6:
                    System.exit(0);
                    break;
                case 7:
                    System.out.print("Entrez l'ISBN du livre à modifier : ");
                    String isbnUpdate = sc.nextLine();
                    System.out.print("Nouveau titre : "); String nt = sc.nextLine();
                    System.out.print("Nouvel auteur : "); String na = sc.nextLine();
                    System.out.print("Nouvelle année : "); int ny = sc.nextInt();
                    sc.nextLine();

                    boolean success = LibraryManager.updateBook(library, bookCount, isbnUpdate, nt, na, ny);
                    
                    if (success) {
                        System.out.println("Livre mis à jour avec succès !");
                        activities.push("Mise à jour du livre ISBN : " + isbnUpdate);
                    } else {
                        System.out.println("Erreur : Aucun livre trouvé avec cet ISBN.");
                    }
                    break;
                            }
                        }
                    }
}