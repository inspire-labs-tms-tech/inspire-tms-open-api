import { BASE_PATH } from "@inspire-labs-tms-tech/inspire-tms-open-api/gen/base";
import { LoadTendersApi } from "@inspire-labs-tms-tech/inspire-tms-open-api/gen";



export class InspireTMS {

  private readonly _loadTenderAPI: LoadTendersApi;
  private readonly _baseURL: string;

  constructor(app: { name: string; } | { base: string; }) {
    this._baseURL = "base" in app ? app.base : BASE_PATH.replace("_", app.name);
    this._loadTenderAPI = new LoadTendersApi(undefined, this._baseURL);
  }

  get baseURL(): string {
    return this._baseURL;
  }

  get loadTenderAPI(): LoadTendersApi {
    return this._loadTenderAPI;
  }

}