package model;


public class Lista implements ILista {
	 int size;
	private No primeiro;
	 public void add(int dado) {
	        if (!contains(dado)) { // verifica se o valor já existe na lista
	            
	            No newNo = new No(dado);
	            if (primeiro == null) {
	                primeiro = newNo;
	            } else {
	                No atual = primeiro;
	                while (atual.proximo != null) {
	                    atual = atual.proximo;
	                }
	                atual.proximo = newNo;
	            }
	            size++;
	        }
	    }
	 public boolean contains(int dado) {
	 
			No atual= primeiro;
	        while (atual != null) {
	            if (atual.dado == dado) {
	            	System.out.println(dado+" Ja existente na Lista!!!");
	                return true;
	            }
	           atual = atual.proximo;
	        }
	        return false;
	    }

	    public int size() {
	    	
	    		int cont = 0;
	    		if (!isEmpty()) {
	    			No auxiliar = primeiro;
	    			while (auxiliar != null) {
	    				cont++;
	    				auxiliar = auxiliar.proximo;
	    			}
	    		}
	    		return cont;
	    	
	    }

		@Override
		public boolean isEmpty() {
			if (primeiro == null) {
				return true;
			} else {
				return false;
			}
		}private No getNo(int pos) throws Exception {
			if (isEmpty()) {
				throw new Exception("Lista Vazia");
			}
			int tamanho = size();
			if (pos < 0 || pos > tamanho - 1) {
				throw new Exception("Posição Inválida");
			}
			No auxiliar = primeiro;
			int cont = 0;
			while (cont < pos) {
				auxiliar = auxiliar.proximo;
				cont++;
			}
			return auxiliar;
		}
		
	    @Override
		public int get(int pos) throws Exception {
			No atual = getNo(pos);
			return atual.dado;
//			return getNo(pos).dado;
		}
	    @Override
		public void remove(int pos) throws Exception {
			if (isEmpty()) {
				throw new Exception("Lista Vazia");
			}
			int tamanho = size();
			if (pos < 0 || pos > tamanho - 1) {
				throw new Exception("Posição Inválida");
			}
			if (pos == 0) {
				removeFirst();
			} else if (pos == tamanho - 1) {
				removeLast();
			} else {
				No atual = getNo(pos);
				No anterior = getNo(pos - 1);
				anterior.proximo = atual.proximo;
			}
			
		}
	    @Override
		public void removeFirst() throws Exception {
			if (isEmpty()) {
				throw new Exception("Lista Vazia");
			}
			primeiro = primeiro.proximo;
		}

		@Override
		public void removeLast() throws Exception {
			if (isEmpty()) {
				throw new Exception("Lista Vazia");
			}
			int tamanho = size();
			if (tamanho == 1) {
				removeFirst();
			} else {
				No penultimo = getNo(tamanho - 2);
				penultimo.proximo = null;
			}
		}
		@Override
		public void addFirst(int valor) {
			No elemento = new No(valor);
			elemento.dado = valor;
			elemento.proximo = primeiro;
			primeiro = elemento;
		}

		@Override
		public void addLast(int valor) throws Exception {
			if (isEmpty()) {
				throw new Exception("Lista Vazia");
			}
			No elemento = new No(valor);
			elemento.dado = valor;
			elemento.proximo = null;
			
			int tamanho = size();
			
			No ultimo = getNo(tamanho - 1);
			ultimo.proximo = elemento;
		}

		@Override
		public void add(int valor, int pos) throws Exception {
			if (isEmpty()) {
				throw new Exception("Lista Vazia");
			}
			int tamanho = size();
			if (pos < 0 || pos > tamanho) {
				throw new Exception("Posição inválida");
			}
			if (pos == 0) {
				addFirst(valor);
			} else if (pos == tamanho) {
				addLast(valor);
			} else {
				No elemento = new No(valor);
				elemento.dado = valor;
				
				No anterior = getNo(pos - 1);
				elemento.proximo = anterior.proximo;
				anterior.proximo = elemento;
			}
		}
}
