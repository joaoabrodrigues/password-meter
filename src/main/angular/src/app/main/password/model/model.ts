export class PasswordRequest {
  password: string;
}

export class PasswordResponse {
  score: number = 0;
  complexity: string = 'Muito curta';
}
  