package travelator;

/**
 * 코틀린 클래스의 경우 private 이 아닌 필드에 대해 get 메소드를 자동으로 만들어준다.
 * - 코틀린의 기본(Default) 접근 제어자는 public
 */

public class Marketing {
  public static boolean isHotmailAddress(EmailAddress address) {
    return address.getDomain().equalsIgnoreCase("hotmail.com");
  }
}
