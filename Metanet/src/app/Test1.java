package app;

	import java.util.Scanner;
	import java.util.ArrayList;
	 
	public class Test1 {
	    public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);
	        // �̸��� ������ ArrayList name ����
	        ArrayList name = new ArrayList();
	        // ��ȣ�� ������ ArrayList num ����
	        ArrayList num = new ArrayList();
	        // �̸�, ��ȣ�� �Է¹��� ���� ����
	        String na, nu;
	        // ���������� while���� Ż���� ���� ����
	        boolean bool = true;
	        
	        // ����ó ���α׷� �ݺ�����
	        while(bool) {
	            System.out.println("1.����ó ���");
	            System.out.println("2.����ó ����");
	            System.out.println("3.����ó ����");
	            System.out.println("4.��� ����ó ����");
	            System.out.println("5.����");
	            // ���⸦ ���ù���
	            int input = sc.nextInt();
	            switch(input) {
	            case 1:
	                System.out.println("����� �̸��� �Է��ϼ���");
	                na = sc.next();
	                // �̸��� ��ϵǾ� ���� �ʴٸ� ����ó ����
	                // indexOf�� ��ü�� ���ٸ� -1 ������ �� ��ġ�� ��ȯ
	                // -1�� ��ȯ�ȴٴ°� �ߺ��� ���ٴ� ���̴�.
	                if(name.indexOf(na) == -1) {
	                    name.add(na);
	                    System.out.println("����� ��ȣ�� �Է��ϼ���");
	                    nu = sc.next();
	                    // �Է¹��� ��ȣ�� ArrayList num�� �߰�
	                    num.add(nu);
	                    System.out.println("��ϵ� �̸��� : " + na + " / ��ȣ�� : " + nu + "�Դϴ�.");
	                // �̸��� ��ϵǾ� �ִٸ� �ߺ��� �̸��� �ִٰ� ��ȯ
	                } else {
	                    System.out.println("�ߺ��� �̸��� �ֽ��ϴ�.");
	                }
	                break;
	        
	            case 2:
	                System.out.println("������ ����ó�� Ȯ���Ͻðڽ��ϱ�?");
	                // ����Ǿ� �ִ� ��� �̸��� Ȯ��
	                for(int i=0; i<name.size(); i++) {
	                    System.out.println("�̸� : " + name.get(i));
	                }
	                na = sc.next();
	                // Ȯ���� �̸��� �ε��� ��ȣ Ȯ��
	                // name.indexOf(na);
	                
	                // ����Ǿ� �ִ� ���� ������ -1�� ���
	                if(name.indexOf(na) == -1) {
	                    System.out.println("��Ͽ� �����ϴ�.");
	                } else {
	                    System.out.println(na + "�� ��ȣ�� " + num.get(name.indexOf(na)));
	                    
	                }
	                break;
	            
	            case 3:
	                System.out.println("������ ����ó�� �����Ͻðڽ��ϱ�?");
	                // ����Ǿ� �ִ� ��� �̸��� String���� ��ȯ�Ͽ� ���
	                for(int i=0; i<name.size(); i++) {
	                    na = (String)name.get(i);
	                    System.out.println(na);
	                }
	                System.out.println("������ �̸��� �Է��ϼ���");
	                na = sc.next();
	                // �Է¹��� �̸��� ArrayList name���� ����
	                System.out.println(name.remove(na));
	                break;
	            
	            case 4:
	                System.out.println("����Ǿ� �ִ� ����ó��");
	                // ����Ǿ� �ִ� ����ó�� �̸��� ��ȣ�� ��� ���
	                for(int i=0; i<name.size(); i++) {
	                    System.out.println("�̸� : " + name.get(i) + " / ��ȣ : " + num.get(i));
	                }
	                // ����Ǿ� �ִ� ���� ������ ����� ����, ����ó�� �߰��ض� ���� ���
	                if(name.size()==0) {
	                    System.out.println("����� �����ϴ�.");
	                    System.out.println("����ó�� �߰����ּ���.");
	                }
	                break;
	                
	            case 5:
	                // �����ϸ� while�� Ż��
	                System.out.println("�����ϰڽ��ϴ�.");
	                bool = false;
	            }
	        }
	    }
	}

